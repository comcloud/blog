//通过ajax请求的数据
let selectData;
//构建的结构数据
let structure = [];
window.onload = function () {
    $(function () {
        let editor = editormd("editor", {
            width: "90%",
            height: 640,
            codeFold: true,
            syncScrolling: "single",
            markdown: "xxxx",     // dynamic set Markdown text
            path: "/assets/editormd/lib/",  // Autoload modules mode, codemirror, marked... dependents libs path
            emoji: true,
            taskList: true,
            tocm: true,         // Using [TOCM]
            tex: true,                   // 开启科学公式TeX语言支持，默认关闭
            flowChart: true,             // 开启流程图支持，默认关闭
            sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            // saveHTMLToTextarea: true,

            // Editor.md theme, default or dark, change at v1.5.0
            // You can also custom css class .editormd-preview-theme-xxxx
            //这个是工具栏的主题设置
            // theme        : (localStorage.theme) ? localStorage.theme : "dark",
            // Preview container theme, added v1.5.0
            // You can also custom css class .editormd-preview-theme-xxxx
            //这个是预览的主题设置
            // previewTheme : (localStorage.previewTheme) ? localStorage.previewTheme : "dark",
            // Added @v1.5.0 & after version is CodeMirror (editor area) theme
            //这是编辑框的主题设置
            // editorTheme  : (localStorage.editorTheme) ? localStorage.editorTheme : "pastel-on-dark",
            /**上传图片相关配置如下*/
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "/smart-api/upload/editormdPic/"//注意你后端的上传图片服务地址
        });

        $.ajax({
            type: 'get',
            url: '/article/getAllLabel',
            data: null,
            success: data => {
                selectData = data;
                relation();
                let fatherLabel = data.firstValue;
                let sonLabel = data.lastValue;
                let father = document.getElementById("father");
                let son = document.getElementById("son");
                fatherLabel.forEach((element) => {
                    let option;
                    if (element.lid === 1) {
                        option = new Option(element.name, element.lid, false, true);
                    } else {
                        option = new Option(element.name, element.lid);
                    }
                    option.value = element.lid;
                    father.options.add(option);
                });
                let count = 0;
                sonLabel.forEach((element) => {
                    let option;
                    if (element.lid === 1 && count === 0) {
                        option = new Option(element.name, element.lid, false, true);
                    } else {
                        option = new Option(element.name, element.lid);
                        count++;
                    }
                    option.value = element.lid;
                    son.options.add(option);
                })
            }
        });
        //查看文章列表事件
        $('#article_list').on('click', function () {
            location.href = '/article/article_list';
        });
        //保存操作事件
        $('#save').on('click', function () {
            articleFunction(true);
        });

        //发布文章事件
        $('#publish').on('click', function () {
            articleFunction(false);
        });

        function articleFunction(isDraft) {
            let content = $('.editormd-markdown-textarea').val();
            let title = $('#title').val();
            let fatherLabel = document.getElementById("father").value;
            let sonLabel = document.getElementById("son").value;
            let article = {
                content,
                title,
                isDraft,
                fatherLabel,
                sonLabel
            };
            $.ajax({
                url: '/article/saveArticle',
                data: article,
                type: 'post',
                success: function (data) {
                    var parse = JSON.parse(data);
                    if (parse.success) {
                        if (parse.isDraft) {
                            alert("保存成功");
                        } else {
                            location.href = "/publish_success";
                        }
                    }
                }
            })
        }
    });
};

function change() {

    let fatherValue = document.getElementById("father").value;
    let son = document.getElementById("son");
    //将子下拉菜单设置为空
    son.options.length = 0;
    let count = 0;
    let sonOptions = [];
    for (let structureElement of structure) {
        //这个地方必须使用==不可以使用===，不可以严格比较(包括类型比较)，我们只是想判断他们的数值是否相等
        if(structureElement.key == fatherValue){
            sonOptions = structureElement.value;
            break;
        }
    }
    console.log(sonOptions);
    sonOptions.forEach((element) => {
        let option;
        if (element.lid === 1 && count === 0) {
            option = new Option(element.name, element.lid, false, true);
        } else {
            option = new Option(element.name, element.lid);
            count++;
        }
        option.value = element.lid;
        son.options.add(option);
    })
}


//构建下拉菜单联动的关系
function relation() {
    let fatherLabel = selectData.firstValue;
    let sonLabel = selectData.lastValue;
    fatherLabel.forEach((element) => {
        //映射关系
        let Entry = {
            //父菜单lid与对应的子菜单
            key: element.lid,
            value: []
        };
        let val = [];
        sonLabel.forEach((ele) => {
            if (Entry.key === ele.fatherLabelId) {
                val.push(ele);
            }
        });
        Entry.value = val;
        structure.push(Entry);
    });
}

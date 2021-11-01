$(
    function ()
    {
        new ClipboardJS('.btn-primary');
        init();
    }
)

/**
 * 页面初始化
 */
function init()
{
    $.ajax
    (
        {
            url : '/listAllContent',
            type : 'GET',
            dataType : 'json',
            success : function (body)
            {
                setHtml(body);
                editEvent();
                backEvent();
                submitEvent();
            },
            error : function ()
            {
                console.log('请求失败');
            }
        }
    );
}

/**
 * 获得数据后输出html
 * @param body 数据
 */
function setHtml(body)
{
    for (el of body)
    {
        let html = '    <div class="component">' +
            '                <div>' +
            '                    <span id="c' + el.contentId + '" class="content col-lg-7"></span>' +
            '                    <div class="btn-group col-lg-5" role="group">' +
            '                        <button type="button" class="btn btn-primary" data-clipboard-action="copy" data-clipboard-target="#c' + el.contentId + '">复制</button>' +
            '                        <button type="button" class="btn btn-success" my="update">修改</button>' +
            '                        <button type="button" class="btn btn-danger">删除</button>' +
            '                        <button type="button" class="btn btn-info">上移</button>' +
            '                        <button type="button" class="btn btn-info">下移</button>' +
            '                        <button type="button" class="btn btn-info">移到最前</button>' +
            '                        <button type="button" class="btn btn-info">移到最后</button>' +
            '                    </div>' +
            '                </div>' +
            '                <div class="hide">' +
            '                    <input type="text" class="content col-lg-7"/>' +
            '                    <div class="btn-group col-lg-5" role="group">' +
            '                        <button type="button" class="btn btn-info" my="mSubmit">提交</button>' +
            '                        <button type="button" class="btn btn-info" my="back">返回</button>' +
            '                    </div>' +
            '                </div>' +
            '            </div>'
        $('div.container').append(html);
        $('span.content:last').text(el.contentMaster);
        $('input.col-lg-7:last').val(el.contentMaster);
    }
}

/**
 * 修改按钮绑定事件
 */
function editEvent()
{
    $('button[my=update]').bind
    (
        'click',
        function ()
        {
            $(this).parent().parent().addClass('hide');
            $(this).parent().parent().next().removeClass('hide');
        }
    );
}

/**
 * 返回按钮绑定事件
 */
function backEvent()
{
    $('button[my=back]').bind
    (
        'click',
        function ()
        {
            $(this).parent().parent().addClass('hide');
            $(this).parent().parent().prev().removeClass('hide');
        }
    );
}

/**
 * 提交按钮绑定事件
 */
function submitEvent()
{
    $('button[my=mSubmit]').bind
    (
        'click',
        function ()
        {
            let value = $(this).parent().prev().val();
            let cid = $(this).parent().parent().prev().children(':first').attr('id');
            var id = cid.substr(cid.indexOf('c')+1);
            $.ajax
            (
                {
                    url : '/updateContextById',
                    type : 'POST',
                    data:JSON.stringify
                    (
                        {
                            "contentId": id,
                            "contentMaster": value
                        }
                    ),
                    headers:
                    {
                        'Content-Type': 'application/json'
                    },
                    success: function ()
                    {
                        window.location.reload();
                    },
                    error: function ()
                    {
                        alert('请求失败');
                    }
                }
            );
        }
    );
}

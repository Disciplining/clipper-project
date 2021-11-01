$(
    function ()
    {
        new ClipboardJS('.btn-primary');
        init();
    }
)

/**
 * 页面初始化，获取数据.
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
            '                    <span id="cid' + el.contentId + '" class="content col-lg-7"></span>' +
            '                    <div class="btn-group col-lg-5" role="group">' +
            '                        <button type="button" class="btn btn-primary" data-clipboard-action="copy" data-clipboard-target="#cid' + el.contentId + '">复制</button>' +
            '                        <button type="button" class="btn btn-success">修改</button>' +
            '                        <button type="button" class="btn btn-danger">删除</button>' +
            '                        <button type="button" class="btn btn-info">上移</button>' +
            '                        <button type="button" class="btn btn-info">下移</button>' +
            '                        <button type="button" class="btn btn-info">移到最前</button>' +
            '                        <button type="button" class="btn btn-info">移到最后</button>' +
            '                    </div>' +
            '                </div>' +
            '                <div class="edit">' +
            '                    <input type="text" class="content col-lg-7" value="sdfaf"/>' +
            '                    <div class="btn-group col-lg-5" role="group">' +
            '                        <button type="button" class="btn btn-info">提交</button>' +
            '                        <button type="button" class="btn btn-info">返回</button>' +
            '                    </div>' +
            '                </div>' +
            '            </div>'
        $('div.container').append(html);
        $('span.content:last').text(el.contentMaster);
    }
}

/**
 * 修改按钮绑定事件
 */
function editEvent()
{
    $('.btn-success').bind
    (
        'click',
        function ()
        {
            $(this).parent().parent().hide();
        }
    );
}

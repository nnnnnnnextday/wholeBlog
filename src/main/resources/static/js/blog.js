$('.menu.toggle').click(function () {
    $('.m-item').toggleClass('m-mobile-hide');
});

$('#payButton').popup({
    popup: $('.payQR.popup'),
    on: 'click',
    position: 'bottom center'
});

tocbot.init({
    tocSelector: '.js-toc',
    contentSelector: '.js-toc-content',
    headingSelector: 'h1,h2,h3',
})

$('.toc.button').popup({
    popup: $('.toc-container.popup'),
    on: 'click',
    position: 'left center'
});
$('.wechat').popup({
    popup: $('.wechat-qr'),
    position: 'left center'
});

var serurl = "127.0.0.1:8080"; //二维码地址
var url = /*[[@{/blog/{id}(id=${blog.id})]]*/"";
var qrcode = new QRCode(document.getElementById("qrcode"), {
    text: serurl+url,
    width: 100,
    height: 100,
    colorDark: "#000000",
    colorLight: "#ffffff",
    correctLevel: QRCode.CorrectLevel.H
});

$('#toTop-button').click(function () {
    $(window).scrollTo(0, 500);
});

var waypoint = new Waypoint({
    element: document.getElementById('waypoint'),
    handler: function (direction) {
        if (direction == 'down') {
            $('#toolbar').show(500);
        } else {
            $('#toolbar').hide(500);
        }

    }
})

$('.ui.form').form({
    fields: {
        title: {
            identifier: 'content',
            rules: [{
                type: 'empty',
                prompt: '请输入评论内容'
            }
            ]
        },
        content: {
            identifier: 'nickname',
            rules: [{
                type: 'empty',
                prompt: '请输入你的名称'
            }]
        },
        type: {
            identifier: 'email',
            rules: [{
                type: 'empty',
                prompt: '请输入正确的邮箱'
            }]
        }
    }
});

$(function (){
    var id = $("[name='blog.id']").val();
    $("#comment-container").load("/comments/"+id);
});

$('#commentpost-btn').click(function (){
    console.log(1);
    var boo = $('.ui.form').form('validate form');
    if (boo) {
        console.log('校验成功');
        postData();
    } else {
        console.log('校验失败');
    }
});

function postData() {
    $('#comment-container').load("/comments",{
        "parentComment.id" : $("[name='parentComment.id']").val(),
        "blog.id" : $("[name='blog.id']").val(),
        "nickname" : $("[name='nickname']").val(),
        "email" : $("[name='email']").val(),
        "content" : $("[name='content']").val()
    },function (responseTxt,statusTxt,xhr){
        $(window).scrollTo($('#comment-container'),500);
        clearContent();
    });
}

function clearContent() {
    $("[name='content']").val('');
    $("[name='parentComment.id']").val(-1);
    $("[name='content']").attr("placeholder","请输入评论信息...");
}

function reply(obj){
    var commentId = $(obj).data('commentid');
    var commentNickname = $(obj).data('commentnickname');
    $("[name='content']").attr("placeholder","@"+commentNickname).focus();
    $("[name='parentComment.id']").val(commentId);
    $(window).scrollTo($('#comment-form'),500);
}

$('#newblog-container').load("/footer/newblog");
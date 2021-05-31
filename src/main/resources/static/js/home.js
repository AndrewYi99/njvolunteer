
// 轮播图 响应式
$(function(){
    $(window).on(`resize`,()=>{
        let clientX = $(window).width();

        let isSHowBigImage = clientX >=900;

        let $allItems = $(`#page_carousel .carousel-item`);
        
        $allItems.each((index,item)=>{
            let src = isSHowBigImage ? $(item).data(`lg-img`):$(item).data(`sm-img`);
            let imgUrl = `url(${src})`

            $(item).css({
                backgroundImage:imgUrl
            })

            if(!isSHowBigImage){
                let imgEle = `<img src="${src}">`;
                $(item).empty().append(imgEle);
            }else{
                $(item).empty();
            }
        });
    });
    $(window).trigger('resize');
});

$(function(){
    　　var nav=$("#header_nav"), //得到导航对象
    　　　　 win=$(window), //得到窗口对象
    　　　　 doc=$(document);//得到document文档对象。
    　　　  //防止页面滚动到60px以下F5刷新后导航不显示　　　
           if(doc.scrollTop()>=60){　　
             $('#header_nav').addClass('fixnav');
           }else{
             $('#header_nav').removeClass('fixnav');
           }　　
           //滚动到60px以下导航显示
    　　　　win.scroll(function(){
    　　　　　if(doc.scrollTop()>=60){//判断滚动的高度
               $("#header_nav").addClass('fixnav');//固定导航样式类名
              }else{
                $("#header_nav").removeClass('fixnav');
              }
            })
    })
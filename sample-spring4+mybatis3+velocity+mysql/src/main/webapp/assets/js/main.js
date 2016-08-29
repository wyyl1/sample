;;(function($){

	var SHARE_URL={"swb":"http://v.t.sina.com.cn/share/share.php?appkey=&url=http://www.tuyinxiang.com",
		"twb":"http://share.v.t.qq.com/index.php?c=share&a=index&url=http://www.tuyinxiang.com&appkey=801448035"}


	$(function(){

		// 返回顶部
		$(window).bind('scroll',function(){
			var len=$(this).scrollTop();

			var top = 85 - len;
			$('.right-side').css('margin-top',top > -45?top:-45 + 'px');

			if(len>=300){
				$('#up').show();
			}else{
				$('#up').hide();
			}
		});

		$('#up').click(function(){
			$(document).scrollTop(0);
		});

		$(".scrollLoading").scrollLoading();

		// 搜索框
		$('input[tyx-data-search]').keypress(function( event ) {
			if ( event.which == 13 ) {
				window.location.href='/?tag='+$(this).val();
			}
		});

		// 弹出分享按钮
		$('a[tyx-data-share-btn]').click(function(){
			$(this).parent().parent().next().toggle();
		});

		$('button[tyx-data-btn-home]').click(function(){
			window.location.href='/';
		});

		// 分享按钮
		$('#share a').click(function(){
			share($(this));
		});

	});

	function ajaxGet(url,data,callback){
		var aa = parseAjaxArg(data,callback);
		$.getJSON(url,aa['data'],function(data){
			ajaxResult(data,aa['callBack']);
		});
	}

	function ajaxPost(url,data,callback){
		var aa = parseAjaxArg(data,callback);
		$.post(url,aa['data'],function(data){
			ajaxResult(data,aa['callback']);
		},'json');
	}

	function parseAjaxArg(data,callback){
		if ( $.isFunction( data ) ) {
			callback = data;
			data = undefined;
		}

		return {'data':data,'callback':callback};
	}

	function ajaxResult(data,callback){
		//loading(1);
		var flag = checkCode(data.code) ;
		if (flag === true){
			if($.isFunction(callback)){
				callback(data.code,data.message);
			}
		}
	}

	function checkCode(code){
		//登录
		if (code == 600){
			login();
			return false;
		} else if (code == 601){
			// 权限
			right();
			return false;
		} else if (code == 500){
			error('内部错误');
			return false;
		}

		return true;
	}

	function login(){
		art.dialog({content:$('#pop-login').get(0),lock: true,fixed: true});
	}

	function right(){
		alert('right');
	}

	function share(obj){
		var sn = obj.attr('tyx-data-share-name');
		var title = '哇~@图印象有好多好看图片，速度来啊，我先分享一下，然后慢慢欣赏';
		var pic = obj.parent().parent().attr('tyx-data-share-pic');
		window.open(SHARE_URL[sn]+'&title='+title+'&pic='+pic, '', 'height=500, width=600');
	}

	function error(msg){
		art.dialog({content:'<span class="font-color-red1"><i class="icon icon-close-circled"></i> '+msg+'</span>',lock: true});
	}

	function tip(msg){
		art.dialog({content:'<span class="font-color-gray"><i class="icon icon-information-circled"></i> '+msg+'</span>',lock: true,time: 1000});
	}

	function tip2(msg){
		art.dialog({content:'<span class="font-color-gray"><i class="icon icon-information-circled"></i> '+msg+'</span>',lock: true});
	}

	function loading(s){
		if(s){
			$('#loading').hide();
		} else {
			$('#loading').show();
		}
	}

	function loading2(msg){
		art.dialog({content:'<img src="/assets/images/loading2.gif" /><span class="font-color-gray loading2">'+msg+'</span>',lock: true});
	}

	function closeDialog(){
		var list = art.dialog.list;
		for (var i in list) {
			list[i].close();
		};
	}

	window.ajaxGet=ajaxGet;
	window.ajaxPost=ajaxPost;
	window.popError=error;
	window.popTip=tip;
	window.popTip2=tip2;
	window.popLogin=login;
	window.loading=loading;
	window.loading2=loading2;
	window.closeDialog=closeDialog;


})(jQuery);

;;;(function(){

	
	$(function(){
		pager();		
	});
	
	//pager
	function pager(){
		var loc = window.location.href;

        loc = loc.replace(/[&]?page=\d*/i,'');

        if (loc.indexOf('?') == -1){
            loc += '?';
        }
        
        $('.pagination .pager-btn').click(function(){
        	var page = $(this).attr('data-page');
        	window.location.href=loc + '&page='+page;
        });

		
	}

})(jQuery);
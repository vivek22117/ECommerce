$(function(){
	
	switch(menu){
	
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Products':
		$('#list').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	default:
		if(menu=='Home') break;
		$('#list').addClass('active');
	    $('#a_'+menu).addClass('active')
		break;
	}
});
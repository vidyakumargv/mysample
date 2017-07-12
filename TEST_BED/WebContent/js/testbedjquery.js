
$(document).ready(function() {
	
	 $("input[name='querySelectd']").change(function () {
	      var maxAllowed = 1;
	      var cnt = $("input[name='querySelectd']:checked").length;
	      if (cnt > maxAllowed) 
	      {
	         $(this).prop("checked", "");
	         alert('Select maximum ' + maxAllowed + ' Levels!');
	     }
	  });
	 
	 $('input[type=checkbox]').on('change', function (e) {
		    if ($('input[name="querySelectd"]:checked').length > 1) {
		        $(this).prop('checked', false);
		        alert("allowed only 1");
		    }
		});
	
});

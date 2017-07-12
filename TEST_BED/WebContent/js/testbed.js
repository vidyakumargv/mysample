/**
 * 
 */

function setQuery(functionid) {
	//alert("functionid:"+functionid);
	var selectCount=1;
	var idName="#"+functionid;
	var txtboxuery=document.getElementById(functionid+"txtbox").value;
	//
	var totalcount =document.getElementsByName("querySelectd").length;
	//var queryParam="";
	var idquery='';
	var queryValue='';
	for (var i = 0; i < totalcount; i++) {
		if (document.getElementsByName("querySelectd")[i].checked) {
			if (selectCount > 1) {
				//document.getElementsByName(functionid).checked = false;
				var ddd='#'+functionid;
				$(ddd).prop('checked', false);
				alert("one selection allowed");
				return;

			}
			selectCount++;
			
		}
		
	}
	
	
	if($(idName).is(':checked')){
		
		var hiddenBoxValue=functionid+"hidden";
	//	var fnptr=document.getElementById(hiddenBoxValue).value;
		document.getElementById(hiddenBoxValue).value=functionid+"-"+txtboxuery;
		
	}
		 
	
}



function doLoadClId() {

	   $.ajax({
           type: "POST",
           url: "/TEST_BED/loadClId.do",
           data: "method=getClId",
           dataType: "json",
           success: function(data){
        	   
        	   
        	//   alert(data)
        	// Create New Option.
        	   
        	   
        	   	$.each(data.result, function(key, val) {
        	   	   
        	   		$.each(val, function(key, val){
					        //	alert(val);
							 var newOption = $('<option>');
							// alert("vsl"+val[1]);
							newOption.attr('value', val[1]).text(val[1]);
		
							// Append that to the DropDownList.
							$('#clId').append(newOption);
		
							// Select the Option.
							// $("#dptcentres_edit > [value=" + temp +
							// "]").attr("selected", "true");
			        	   
        	   		});
        	   	   	
        	   	});
           
           },
           error: function(e){
               alert('Error doSchemaTemplatePost: ' + e);
           }
       });
       
   }

function  loadSmId(){
//	alert("ssd");
	var clId=document.getElementById("clId").value;
	//document.getElementByName("mehod").value = "loadClId";
//	alert("clId:"+clId)
   $.ajax({
       type: "POST",
       url: "/TEST_BED/loadSmId.do",
       data: "method=getSmId&clId="+clId,
       dataType: "json",
       success: function(data){
    	   
    	   
    	//   alert(data)
    	// Create New Option.
    	   
    	   
    	   	$.each(data.result, function(key, val) {
    	   		$.each(val, function(key, val){
					    	   	// alert(val);
					var newOption = $('<option>');
					// alert("vsl"+val[1]);
					newOption.attr('value', val[1]).text(val[1]);

					// Append that to the DropDownList.
					$('#smId').append(newOption);

					// Select the Option.
					// $("#dptcentres_edit > [value=" + temp +
					// "]").attr("selected", "true");
    	   
    	   		});	
    	   	});
       
       },
       error: function(e){
           alert('Error doSchemaTemplatePost: ' + e);
       }
   });
   
}

function  loadSlNo(){
//	alert("ssd");
	var clId=document.getElementById("clId").value;
	var smId=document.getElementById("smId").value;
	//document.getElementByName("mehod").value = "loadClId";
//	alert("clId:"+clId)
   $.ajax({
       type: "POST",
       url: "/TEST_BED/loadSlNo.do",
       data: "method=getSlNo&clId="+clId+"&smId="+smId,
       dataType: "json",
       success: function(data){
    	   
    	   
    	//   alert(data)
    	// Create New Option.
    	   
    	   
    	   	$.each(data.result, function(key, val) {
    	   		$.each(val, function(key, val){
					
					//From
    	   			var newOptionFrom = $('<option>');
					newOptionFrom.attr('value', val[1]).text(val[1]);
					
					//To
					var newOptionTo = $('<option>');
					newOptionTo.attr('value', val[1]).text(val[1]);

					// Append that to the DropDownList.
					$('#slNoFrom').append(newOptionFrom);
					$('#slNoTo').append(newOptionTo);
					// Select the Option.
					// $("#dptcentres_edit > [value=" + temp +
					// "]").attr("selected", "true");
    	   		});
    	   	   	
    	   	});
       
       },
       error: function(e){
           alert('Error doSchemaTemplatePost: ' + e);
       }
   });
   
}

//LOAD QUERY TABLE

function  loadQueryTable(){
	//alert("loadQueryTable");
	var clId=document.getElementById("clId").value;
	var smId=document.getElementById("smId").value;
	var fnSubType=document.getElementById("fnSubType").value;
	var fnOutput=document.getElementById("fnOutput").value;
	var slNoFrom=document.getElementById("slNoFrom").value;
	var slNoTo=document.getElementById("slNoTo").value;
	
	//document.getElementByName("mehod").value = "loadClId";
		//alert("smethod=getTestDAO&clId="+clId+"&smId="+smId+"&fnSubType="+fnSubType+"&fnOutput="+fnOutput+"&slNoFrom="+slNoFrom+"&slNoTo="+slNoTo);
   $.ajax({
       type: "POST",
       url: "/TEST_BED/loadQueryTable.do",
       data: "method=getTestDAO&clId="+clId+"&smId="+smId+"&fnSubType="+fnSubType+"&fnOutput="+fnOutput+"&slNoFrom="+slNoFrom+"&slNoTo="+slNoTo,
       dataType: "json",
       success: function(data){
    	   
    	   
    	//   alert(data)
    	// Create New Option.
    	   
    	   var trHTML = '';
    	   	$.each(data.result, function(key, val) {
    	   		$.each(val, function(key, val){
					
    	   			
			            trHTML += '<tr color=><td>' + val[1] + '</td><td>' + val[10] + '</td><td>' + val[2]+ '</td><td>' + val[3]+ '</td><td>'+val[4]+'</td><td>'+val[11]+'</td><td>'+val[6]
			            +'</td><td><textarea  cols="25" rows="5" disabled="true">'+val[7]+'</textarea></td><td><textarea  cols="40" rows="3" id="'+val[10]+'txtbox" title="'+val[8]+'">'+val[9]+'</textarea></td> <td><input type="checkbox" name="querySelectd" id="'+val[10]+'"  value="'+val[10]+'" onclick=javascript:setQuery("'+val[10]+'")  ></input>'+' <input type="hidden" id="'+val[10]+'hidden" name="querySelectdHidden" value=""  /></td></tr>';
			      
					
    	   		});
    	   	   	
    	   	});
    	    //$('#querytable').html("");
    	    $('#querytable').append(trHTML);
       
       },
       error: function(e){
           alert('Error doSchemaTemplatePost: ' + e);
       }
   });
   
}


function runQuery() {
	//alert("runQuery");
			
	//alert(document.getElementsByName("querySelectdHidden").length);
	var count =document.getElementsByName("querySelectd").length;
	
	/*var rates = document.getElementsByName('querySelectdHidden');
	var rate_value;
	for(var i = 0; i < rates.length; i++){
	    if(rates[i].checked){
	        rate_value = rates[i].value;
	    }
	}*/
	//var queryParam="";
	var idquery='';
	var queryValue='';
	for(var i=0;i<count;i++){
		
		
		if(document.getElementsByName("querySelectd")[i].checked){
			
			//alert(document.getElementsByName("querySelectd")[i].value);
			idquery=document.getElementsByName("querySelectd")[i].value;
			queryValue=document.getElementById(idquery+"hidden").value;
			break;
		}
	 //queryParam=queryParam+document.getElementsByName("querySelectdHidden")[i].value;
	}
	
//	alert(encodeURI(queryValue));
	var encodedQueryValue=encodeURI(queryValue);
		   $.ajax({
	           type: "POST",
	           url: "/TEST_BED/runQuery.do",
	           data: "method=runQuery&runQueryParam="+encodedQueryValue,
	           dataType: "json",
	           success: function(data){
	        	   
	        	   
	           	//   alert(data)
	           	// Create New Option.
	        	   trHTML="<table>";
	           	   
	           	   var trHTML = '';
	           	   	$.each(data.result, function(key, val) {
	           	   		$.each(val, function(key, val){
	       			      var countRow=val.length;
	       			      trHTML += "<tr>";
	           	   			for(var i=0;i < countRow;i++){
	           	   			trHTML += "<td>"+val[i]+"</td>"	;
	           	   				
	           	   				
	           	   			}
	           	   			trHTML += "</tr>";
	           	   			//alert("sixzw:"+val.legth);
	       			          // trHTML += '<tr><td>' + val[1] + '</td><td>' + val[2]+ '</td><td>' + val[3]+ '</td><td>'+val[4]+'</td><td>'+val[5]+'</td><td>'+val[6]
	       			           // +'</td><td><textarea  cols="25" rows="5" disabled="true">'+val[7]+'</textarea></td><td><textarea  cols="40" rows="3" id="'+val[6]+'txtbox" title="'+val[8]+'">'+val[9]+'</textarea></td> <td><input type="checkbox" name="querySelectd" id="'+val[6]+'"  value="'+val[6]+'" onclick=javascript:setQuery("'+val[6]+'")  ></input>'+' <input type="hidden" id="'+val[6]+'hidden" name="querySelectdHidden" value=" "  /></td></tr>';
	       				
	           	   		});
	           	   	   	
	           	   	});
	           	   	trHTML += "</table>";
	           	   	$('#resultDiv').html("");
	           	    $('#resultDiv').append(trHTML);
	              
	              },
	           error: function(e){
	        	 	$('#resultDiv').html("");
	        	   $('#resultDiv').append("<font color='red' >Error at Query</font>");
	               //alert('Error doSchemaTemplatePost: ' + e);
	           }
	       });
	       
	   }


function commitQuery() {
	//alert("commitQuery");
			
	//alert(document.getElementsByName("querySelectdHidden").length);
	var count =document.getElementsByName("querySelectd").length;
	
	/*var rates = document.getElementsByName('querySelectdHidden');
	var rate_value;
	for(var i = 0; i < rates.length; i++){
	    if(rates[i].checked){
	        rate_value = rates[i].value;
	    }
	}*/
	//var queryParam="";
	var idquery='';
	var queryValue='';
	for(var i=0;i<count;i++){
		
		
		if(document.getElementsByName("querySelectd")[i].checked){
			
			//alert(document.getElementsByName("querySelectd")[i].value);
			idquery=document.getElementsByName("querySelectd")[i].value;
			queryValue=document.getElementById(idquery+"hidden").value;
			break;
		}
	 //queryParam=queryParam+document.getElementsByName("querySelectdHidden")[i].value;
	}
	
	//alert(encodeURI(queryValue));
	var encodedQueryValue=encodeURI(queryValue);
		   $.ajax({
	           type: "POST",
	           url: "/TEST_BED/commitQuery.do",
	           data: "method=commit&runQueryParam="+encodedQueryValue,
	           dataType: "json",
	           success: function(data){
	        	   
	        	   
	          /* 	//   alert(data)
	           	// Create New Option.
	        	   trHTML="<table>";
	           	   
	           	   var trHTML = '';
	           	   	$.each(data.result, function(key, val) {
	           	   		$.each(val, function(key, val){
	       			      var countRow=val.length;
	       			      trHTML += "<tr>";
	           	   			for(var i=0;i < countRow;i++){
	           	   			trHTML += "<td>"+val[i]+"</td>"	;
	           	   				
	           	   				
	           	   			}
	           	   			trHTML += "</tr>";
	           	   			//alert("sixzw:"+val.legth);
	       			          // trHTML += '<tr><td>' + val[1] + '</td><td>' + val[2]+ '</td><td>' + val[3]+ '</td><td>'+val[4]+'</td><td>'+val[5]+'</td><td>'+val[6]
	       			           // +'</td><td><texta area  cols="25" rows="5" disabled="true">'+val[7]+'</textarea></td><td><textarea  cols="40" rows="3" id="'+val[6]+'txtbox" title="'+val[8]+'">'+val[9]+'</textarea></td> <td><input type="checkbox" name="querySelectd" id="'+val[6]+'"  value="'+val[6]+'" onclick=javascript:setQuery("'+val[6]+'")  ></input>'+' <input type="hidden" id="'+val[6]+'hidden" name="querySelectdHidden" value=" "  /></td></tr>';
	       				
	           	   		});
	           	   	   	
	           	   	});
	           	   	trHTML += "</table>";*/
	        	   $('#resultarea').html("");
	           	    $('#resultarea').append("<font color='greens' >SUCCESSFULLY INSERTED</font>");
	              
	              },
	           error: function(e){
	        	   $('#resultarea').html("");
	        	   $('#resultarea').append("<font color='red' >FAILED</font>");
	               //alert('Error doSchemaTemplatePost: ' + e);
	           }
	       });
	       
  }






           	
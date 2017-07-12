<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<html>
<head>
<script type="text/javascript"  src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/testbed.js"></script>
<script type="text/javascript" src="js/testbedjquery.js"></script>


<style>
table, td, th {
	border: 1px solid #ddd;
	text-align: left;
}

table {
	border-collapse: collapse;
}

th, td {
	padding: 4px;
}
</style>

<title>Form Report Test for DAO</title>

</head>
<body>
	<!--include jquery + javascript handler to dynamicaly change the contet based on ajax replay-->
	<!--

sample jquery functions
selection part:

function onLoad : show clIds
function onSelectClId: show smId
function onSelectSmId: show sLnoFrom;
function onSelectSLnoFrom: show sLNoTo
function onSelectSLnoTo: show testDAO table content

Test result part:

function onClickRunQuery : show Results
function onClickCompareWithDB : show validated test result 
-->

	<!--include jsp tag libraries-->

	<!--Form selection------------------------->
	<html:form action="runquery.do" method="get" id="queryform" >
	
		<input type="hidden" name="method" value="runQuery">
		<input type="hidden" name="frmJsp" value="testFrmnRptDAO.jsp">
		<h4>Form Section</h4>

		<!--Form selection item option display-->
		
						<div id="resultarea"></div>
			
		<table>
			<tr>
				<!--on load of page call form action='testDAO' method='getClId'-->
				<td>ClId: 
				<select id="clId" name="clId" onchange="javascript:loadSmId();">
					 			<option value="">Select One</option>		
				</select>
				</td>
				<!-- on select of ClId call form action='testDAO' method='getSmId'-->
			</tr>

			<tr>
				<td>SmId: <select id="smId" name="smId" onchange="javascript:loadSlNo();">
						<option value="">Select One</option>	
				</select>
				</td>
				<!-- on select of SmId call form action='testDAO' method='getSlNo'-->
			</tr>


			<tr>
				<td>Query Type <select id="fnSubType" name="fnSubType"> 
						<option value="SELECT">SELECT</option>
						<option value="INSERT">INSERT</option>
				</select>
				</td>
			</tr>

			<tr>
				<td>Query Return Type <select id="fnOutput" name="fnOutput">
						<option value="session">Session</option>
						<option value="bean">Bean</option>
				</select>
				</td>

			</tr>

			<tr>
				<td>From SL.NO <select id="slNoFrom" name="slNoFrom" >
					<option value="">Select One</option>	
				</select>
				</td>

				<td>To SL.NO <select  id="slNoTo" name="slNoTo" onchange="javascript:loadQueryTable();">
					<option value="">Select One</option>	
				</select>
				</td>
				<!-- on select of To SL.NO call form action='testDAO' method='getTestDAO'-->
			</tr>
			<tr>
			
			</tr>
			</table>
			<table>

				<!--Form selected item display-->
				<h4>Showing selected Items list below:</h4>

				<table id="querytable">
					<thead>
						<th>slNo</th>
						<th>fnptr</th>
						<th>reqtId</th>
						<th>condId</th>
						<th>subCondId</th>
						<th>Verified</th>
						<th>fnId</th>
						<th>actualQueryBFTest</th>
						<th>perfectQueryAFTest</th>
					</thead>

					<!--use jsp loop or jstl tag library to dynamically display content based on Ajax replay-->
					<!-- <tr>
						<td>1</td>
						<td>snkReqICDOff1</td>
						<td>condICDoff1ReqExist</td>
						<td>condICDoff1TimeLimitSatisfied</td>
						<td>def1</td>
						<td>off1GetStET</td>
						<td><textarea name="Text1" cols="40" rows="3">Select startTime,endTime from tt_reqt where clId='Girija' & reqtId=' snkReqICDOff1'</textarea>
						</td>
					</tr> -->
				</table>
				<!--loop or jstl tag close-->

				<!--Form Buttons-->
				<br>
				<table>
					<tr>
						<td>
							<button type="submit" onclick="javascript:runQuery();">Run Query</button>
						</td>
						
						<td>
							<button type="submit" onclick="javascript:commitQuery();">Commit</button>
						</td>
						<td>
							<button type="submit">Exit</button>
						</td>
						<td>
							<button type="submit">Cancel</button>
						</td>
						<!-- <td>
							<button type="submit">Debug</button>
						</td>
						<td>
							<button type="submit">Pause</button>
						</td>
						<td>
							<button type="submit">Stop</button>
						</td>
						<td>
							<button type="submit">Cancel</button>
						</td> -->
					</tr>
				</table>
			</table>
		</table>
		
	
	</html:form>

	<!--Report section----------------------------->
	<h4>Report Section</h4>
	<form>

		<!--Report Results-->
		<h4>Showing Test Results:</h4>


		<div id="resultDiv"></div>
		
		
		
	<!-- 	<table>
			<thead>
				<th>clId</th>
				<th>smId</th>
				<th>reqId</th>
				<th>condId</th>
				<th>subCondId</th>
				<th>logicId</th>
				<th>fnId</th>
				<th>query</th>
				<th>objName</th>
				<th>Name</th>
				<th>value</th>
				<th>Test result</th>
			</thead>
			use jsp loop/tag library to dynamically display content based on Ajax replay
			<tr>
				<td>Girijaa</td>
				<td>Opr</td>
				<td>snkReqICDOff1</td>
				<td>condICDoff1ReqExist</td>
				<td>condICDoff1TimeLimitSatisfied</td>
				<td>def1</td>
				<td>off1GetStET</td>
				<td>Select startTime,endTime from tt_reqt where<br>
					clId='Girija' & reqtId=' snkReqICDOff1'
				</td>
				<td>off1GetStET</td>
				<td></td>
				<td></td>
				<td><input type="checkbox" name="" value=""></td>
			</tr>
			jsp loop/tag close
		</table> -->

		<!--Report Buttons-->
		<!-- <br>
		<table>
			<tr>
				<td>
					<button type="submit">Compare to db</button>
				</td>
				
				
			</tr>
		</table> -->
		<script>
		
		  window.onload = function() {
			 // alert("called onloasd");
		//	  function doLoadClId() {
				//alert("ssd");
					//	document.getElementsByName("method").value="loadClId";
						//document.getElementByName("mehod").value = "loadClId";
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
				       
				   //}
	          };
			
		</script>
	</form>
</body>
</html>
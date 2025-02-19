<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet" >
<title>驗證信已寄出</title>
</head>
<body>

<div class="modal" tabindex="-1" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">驗證信已寄出</h5>
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<h4><span class="badge badge-secondary badge-danger">請在三天內完成驗證！</span></h4>
      	<span class="form-text text-muted">5秒後將自動跳轉至首頁</span>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="location.href='${contextRoot}/'">返回首頁</button>
      </div>
    </div>
  </div>
</div>

<script src="${contextRoot}/js/jquery-3.6.0.js"></script>
<script src="${contextRoot}/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('#myModal').modal('show')
		
		
		var timeout = setTimeout(toIndex, 5000);
		
		function toIndex() {
			window.location.href='${contextRoot}/';
		}

	})
	
</script>
</body>
</html>
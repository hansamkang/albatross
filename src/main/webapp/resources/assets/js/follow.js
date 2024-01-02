let followService = (function(){
	
	//팔로우 삭제
	function remove(fid){
		console.log('팔로우 삭제 함수 들어옴!');
		$.ajax({
    		url: '/follow/' + fid,
    		type: 'DELETE',
    		success: function(result) {
      		// 서버에서 "success" 또는 "fail" 문자열을 반환하므로, 이를 확인하여 처리합니다.
      			if(result === 'success') {
        			console.log('팔로우 해제 성공!');
      			} else {
        			console.log('팔로우 해제 실패!');
      			}
    		},
    		error: function(request, status, error) {
      			console.log('Ajax 요청 실패!');
      			console.log('status:', status);
      			console.log('error:', error);
    		}
  		});
	}
	

 	// 팔로우 하기
 	function add(follow, callback){
 		console.log("add follow.....");
 		
 		$.ajax({
 			url:"/follow/new",
 			type:"post",
 			data:JSON.stringify(follow),
 			contentType: "application/json; charset=utf-8",
 			success: function(result){
 				if(callback){
 					callback(result);
 				}
 			}
 		});
 	}
 	
 	// 팔로우 하기
 	function exists(follow, callback){
 		console.log("add follow.....");
 		
 		$.ajax({
 			url:"/follow/exists",
 			type:"post",
 			data:JSON.stringify(follow),
 			contentType: "application/json; charset=utf-8",
 			success: function(result){
 				if(callback){
 					callback(result);
 				}
 			}
 		});
 	}
 	
 	//팔로우 목록 가져오기
	function get(uuid, callback){
		console.log("get follow....."+ uuid);
	
		$.get("/follow/list/" + uuid, function(follow){
			if(callback){ callback(follow); }
		});
	}
 	
 	
	return{add: add, remove: remove, exists: exists, get:get}
})();
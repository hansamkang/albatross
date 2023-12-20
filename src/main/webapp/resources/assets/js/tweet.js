let tweetService = (function(){
	
	function get(tid, callback){
		$.get("/tweet/" + tid, function(tweet){
			if(callback){ callback(tweet); }
			});
	}
	
	function getTweetList(param, callback, error){
 		let page = param.page || 1; //let variable = a || b; ----> a가  값이 없으면 b로 사용된다. 
 		let tempType = param.type || "T"
 		let tempKeyword = param.keyword || "nomal"
 		$.ajax({
    		url: '/tweet/list',
    		type: 'GET',
    		dataType: 'json',
    		data: {
        		pageNum: page, 
        		amount: 10, 
        		type: tempType,
        		keyword: tempKeyword
    		},
    		success: function(result) {
        		if(callback){
 					callback(result);
 				}
    		},
    		error: function(error) {
        		console.error(error);
    		}
		});		
 	}
 	
 	//추가하기
 	function add(tweet, callback){
 		console.log("add tweet.....");
 		
 		$.ajax({
 			url:"/tweet/new",
 			type:"post",
 			data:JSON.stringify(tweet),
 			contentType: "application/json; charset=utf-8",
 			success: function(result){
 				if(callback){
 					callback(result);
 				}
 			}
 		});
 	}
 	
	return{get:get, getTweetList:getTweetList, add: add}
})();
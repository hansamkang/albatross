let tweetService = (function(){
	
	function get(tid, callback){
		$.get("/tweet/" + tid, function(tweet){
			if(callback){ callback(tweet); }
			});
	}
	
	function getTweetList(param, callback, error){
 		let page = param.page || 1; //let variable = a || b; ----> a가  값이 없으면 b로 사용된다. 
 		
 		$.getJSON("/tweet/list/" + page + ".json", function(result){
 			if(callback){
 				callback(result);
 			}		
 		}).fail(function(xhr, status, err){
 			if(error){
 				error(err);
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
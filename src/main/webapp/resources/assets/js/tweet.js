let tweetService = (function(){
	
	function getTweet(tid, callback){
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
 	
	return{getTweet:getTweet, getTweetList:getTweetList}
})();
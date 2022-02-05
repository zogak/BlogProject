$(document).ready(function(){
	var postId = $('#detail_post_id').attr("value");
	var title = "";
	var postContent = "";

	//console.log("postId - " + postId);
	$.ajax({
        url: "/post?id="+postId
    }).then(function(data) {
       console.log(data);
	   title = data.title;
	   postContent = data.postContent;
       $('#detail_title').text(title);
       $('#detail_user').text(data.userName);
       $('#detail_date').text(data.updtDate);
       $('#detail_content').text(postContent);
    }, function(err) {
    	console.log(err.responseJSON);
    });

	$.ajax({
		url: "/comments?post_id="+postId,
		method: "GET"
	}).then(function(data) {
		console.log(postId);
		$.each(data, function(index, e) {
			$('#comment-list').append(
				'<div><div><b>' + e.userName
				+ '</b></div><p></p>'
				+ '<span>'+ e.content +'</span></div><hr>');
		});
		console.log(data);
	}, function(err) {
		console.log(err.responseJSON);
	});

	$('#detail_delete_btn').click(function(){
		console.log("delete button click! - " + postId);
		$.ajax({
	        url: "/post?id="+postId,
	        method: "DELETE"
	    }).then(function(data) {
	    	window.location.href = '/';
	    }, function(err) {
	    	alert(err.responseJSON);
	    });
	});

	$('#modify_btn').click(function (){
		console.log(title);
		console.log(postContent);
		$('input[name=mo_title]').attr('value',title);
		$("textarea[name=mo_content]").html(postContent);
	});

	$('#save_post_btn').click(function(){
		var title = $('#modify_title_text').val();
		var postContent = $('#modify_content_text').val();
		
		console.log(postId);
		console.log(title);
		console.log(postContent);
		
		var param = {
			id: postId,
			title: title,
			postContent: postContent
		}
		
		$.ajax({
	        url: "/post",
	        method: "PUT",
	        dataType: 'json',
			contentType: 'application/json',
            data: JSON.stringify(param)
	    }).then(function(data) {
	    	window.location.href = '/detail/'+postId;
	    }, function(err) {
	    	alert(err.responseJSON);
	    });
	});

	$('#create_comment_text').click(function(){
		var userName = $('#comment_user').val();
		var content = $('#comment_text').val();

		console.log(postId);
		console.log(userName);
		console.log(content);

		var param = {
			postId: postId,
			userName: userName,
			content: content
		}

		$.ajax({
			url: "/comment",
			method: "POST",
			dataType: 'json',
			contentType: 'application/json',
			data: JSON.stringify(param)
		}).then(function(data) {
			window.location.href = '/detail/'+postId;
		}, function(err) {
			alert(err.responseJSON);
		});
	});

});
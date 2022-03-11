$(function(){
    $("#more").click(function(){
        var next_page = parseInt($(this).attr("current-page")) + 1;

        $.ajax({
            method : "GET",
            url : "/post",
            data : {"page" : next_page}
        }).done(function(response){
          for(var post of response){
              $("#more-posts").append("<div class=\"post-preview\">" +
                  "<a href=\"/post/" + post.id + "\">" +
                  "<h2 class=\"post-title\">" +
                  post.title +
                  "</h2>\n" +
                  "<h3 class=\"post-subtitle\">" +
                  post.content +
                  "</h3></a><p class=\"post-meta\">Posted by" +
                  post.username +
                  "</p></div><hr class=\"my-4\" />");
          }
        });
        $(this).attr("current-page", next_page);
    });

    $("#create_button").click(function(){
        var title = $("#post-title").val();
        var username = $("#post-username").val();
        var content = $("#post-content").val();

        $.ajax({
            method : "POST",
            url : "/post",
            data : JSON.stringify({
                "title" : title,
                "username" : username,
                "content" : content
            }),
            contentType : "application/json"
        }).done(function(response){
           console.log("Post creation success!");
           window.location.href = "/";
        });
    });

    $("#edit_button").click(function(){
        var id = $("#edit-post-id").val();
        var title = $("#edit-post-title").val();
        var content = $("#edit-post-content").val();

        $.ajax({
            method : "PUT",
            url : "/post",
            data : JSON.stringify({
                "id" : id,
                "title" : title,
                "content" : content
            }),
            contentType: "application/json"
        }).done(function(response){
           console.log("Post creation success");
           window.location.href = "/post/" + id;
        });
    });

    $("#delete_button").click(function(){
        var id = $("#post-id").val();
        console.log(id);
        $.ajax({
            method : "DELETE",
            url : "/post",
            data : {"id" : id}
        }).done(function(response){
            console.log("deleted");
        });
    });

    $("#comment-save-button").click(function(){
        console.log("clicked");
        var username = $("#comment-username").val();
        var content = $("#comment-content").val();
        var post_id = $("#post-id").val();

        console.log(username + content + post_id);

        $.ajax({
            method : "POST",
            url : "/comment",
            data : JSON.stringify({
                "username" : username,
                "content" : content,
                "post_id" : post_id
            }),
            contentType : "application/json"
        }).done(function(response) {
                console.log("Comment creation success");
                window.location.reload();
            });
    });

    $("#more-comment-button").click(function(){
        var next_page = parseInt($(this).attr("current-comment-page")) + 1;
        var post_id = parseInt($("#post-id").val());
        $.ajax({
            method: "GET",
            url: "/comment",
            data: {
                "page": next_page,
                "post_id": post_id
            }
        }).done(function(response) {
                for(var comment of response) {
                    $("#more-comments").append("<div class=\"comment_text\"><div class=\"etc\">" +
                        "<div class=\"name\">" +
                        comment.username +
                        "</div></div><p>" +
                        comment.content +
                        "</p><div class=\"edit_btns\">" +
                        "<button class=\"comment-edit-form-button\">수정</button>" +
                        "<button class=\"comment-delete-button\">삭제</button></div>" +
                        "<textarea class=\"edit comment-edit\" name=\"\" id=\"edit2\" cols=\"30\" rows=\"10\" placeholder=\"댓글을 입력해주세요\">" +
                        comment.content +
                        "</textarea><div class=\"save_btns comment-edit\">" +
                        "<button class=\"comment-edit-cancel-button\">취소</button>" +
                        "<button class=\"save comment-edit-button\">저장하기</button></div>" +
                        "<input type=\"hidden\" class=\"comment-id\" value=\"" +
                        comment.id +
                        "\"></div>\"");
                }

                $(".comment-edit").hide();
            });
        $(this).attr("current-comment-page", next_page);
    });

    $(".comment-edit").hide();

    $(".comment-edit-form-button").click(function(){
        $(this).closest(".comment_text").find(".comment-edit").show();
    });

    $(".comment-edit-cancel-button").click(function(){
        $(this).closest(".comment_text").find(".comment-edit").hide();
    });
});
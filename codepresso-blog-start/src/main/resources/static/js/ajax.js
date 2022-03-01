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
                  "<a href=\"#\">" +
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

    $(".comment-edit").hide();

    $(".comment-edit-form-button").click(function(){
        $(this).closest(".comment_text").find(".comment-edit").show();
    });

    $(".comment-edit-cancel-button").click(function(){
        $(this).closest(".comment_text").find(".comment-edit").hide();
    });
});
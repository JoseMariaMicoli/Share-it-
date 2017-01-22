package com.shareit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shareit.Entity.Post;
import com.shareit.Service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/post", method = RequestMethod.GET)
	@ResponseBody
	public Object index(){
		return postService.findAll();
	}
	
	@RequestMapping(value = "/post/create", method = RequestMethod.PUT)
	@ResponseBody
	public String create(@RequestBody Post post){
		String postId = "";
		
		try {
			postService.save(post);
			postId = String.valueOf(post.getId());
		} catch (Exception e) {
			// TODO: handle exception
			return "Error creating the post: " + e.toString();
		}
		
		return "Post succesfully created with id = " + postId;
	}
	
	@RequestMapping("/post/update/{id}")
	@ResponseBody
	public String update(@RequestBody Post post, @PathVariable Long id){
		
		try {
			post.setId(id);
			postService.save(post);
		} catch (Exception e) {
			// TODO: handle exception
			return "Error updating the post: " + e.toString();
		}
		
		return "Post succesfully updated!";
	}
	
	@RequestMapping("/post/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id){
		
		try {
			Post post = postService.findById(id);
			postService.delete(post);;
		} catch (Exception e) {
			// TODO: handle exception
			return "Error deleting the post: " + e.toString();
		}
		
		return "Post succesfully deleted!";
	}
}

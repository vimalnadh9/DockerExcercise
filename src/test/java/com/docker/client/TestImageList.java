package com.docker.client;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import com.spotify.docker.client.messages.Image;


public class TestImageList {

	@Test
	public void test() {
		
		DockerClientUtil clientUtil = new DockerClientUtil();
		
		List<Image> listImages =	clientUtil.listImages("hello-world");
		listImages.forEach(image->{
			List<String> tags = image.repoTags();
			tags.forEach(System.out::println);
			assertTrue(tags.contains("hello-world:latest"));
		});
	
		
	}
	

}

package com.docker.client;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificates;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.DockerClient.ListImagesParam;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Image;

public class DockerClientUtil {

	public List<Image> listImages(String imageName) {
		List<Image> listImages = new ArrayList<Image>();
		try {


			final DockerClient docker = DefaultDockerClient.builder()
				    .uri(URI.create("https://192.168.99.100:2376"))
				    .dockerCertificates(new DockerCertificates(Paths.get("C:/Users/ganjiv1/.docker/machine/machines/default")))
				    .build();
			
			listImages = docker.listImages(ListImagesParam.byName(imageName));
			listImages.forEach(System.out::println);
		} catch (DockerCertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DockerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return listImages;
		

	}

}

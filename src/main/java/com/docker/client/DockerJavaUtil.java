package com.docker.client;

import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.SearchItem;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

public class DockerJavaUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DockerClientConfig  config  = DefaultDockerClientConfig.createDefaultConfigBuilder()
										.withDockerHost("tcp://192.168.99.100:2376")
										.withDockerTlsVerify(true)
										.withDockerCertPath("C:/Users/ganjiv1/.docker/machine/machines/default")
										.build();
		DockerClient dockerClient = DockerClientBuilder.getInstance(config).build();
		
		Info info = dockerClient.infoCmd().exec();
		System.out.println(info);
		
		List<SearchItem> dockerSearch = dockerClient.searchImagesCmd("hello-world").exec();
		dockerSearch.forEach(item->System.out.println(item.getName()));		
		//System.out.println("Search returned" + dockerSearch.));
		
	}

}

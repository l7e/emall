package com.emall;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@SpringCloudApplication
public class EmallGateway
{
    public static void main(String[] args)
    {
        SpringApplication.run(EmallGateway.class);
    }
}

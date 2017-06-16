/*
 * (C) Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     ohun@live.cn (夜色)
 */

package com.shinemo.openapi.demo;

import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.OpenApiConfiguration;
import com.shinemo.openapi.client.web.OpenApiCallbackServlet;
import com.shinemo.openapi.client.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by ohun on 2017/4/19.
 *
 * @author ohun@live.cn (夜色)
 */
public final class CustomWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //1.创建OpenApiClient
        OpenApiClient openApiClient = createConfig().create();

        //2.创建OpenApiAesKeyServlet
        OpenApiCallbackServlet openApiCallbackServlet = createOpenApiCallbackServlet(openApiClient);


        ServletRegistration.Dynamic openApiCallbackServletRegistration = servletContext.addServlet("OpenApiCallbackServlet", openApiCallbackServlet);
        openApiCallbackServletRegistration.addMapping("/callback");

        System.err.println("===================================================================");
        System.err.println("===============OPEN-API-CALLBACK SERVER START SUCCESS==============");
        System.err.println("===================================================================");
    }

    private static OpenApiCallbackServlet createOpenApiCallbackServlet(OpenApiClient openApiClient) {
        OpenApiCallbackServlet openApiCallbackServlet = new OpenApiCallbackServlet();
        MyCallbackEventReceiver callbackEventReceiver = new MyCallbackEventReceiver();
        callbackEventReceiver.setOpenApiClient(openApiClient);
        openApiCallbackServlet.setCallbackEventReceiver(callbackEventReceiver);
        return openApiCallbackServlet;
    }


    private static OpenApiConfiguration createConfig() {
        OpenApiConfiguration configuration = new OpenApiConfiguration();
        configuration.setBaseUrl(Configs.getString("openapi.http.baseUrl"));
        configuration.setAppId(Configs.getInt("openapi.appId"));
        configuration.setAppSecret(Configs.getString("openapi.appSecret"));
        configuration.setAppToken(Configs.getString("openapi.appToken"));
        configuration.setConnectTimeoutMillis(Configs.getInt("openapi.http.connectTimeoutMillis"));
        configuration.setMaxRetry(1);
        return configuration;
    }
}

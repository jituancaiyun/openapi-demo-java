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

import com.shinemo.openapi.client.callback.CallbackEventReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ohun on 2017/5/11.
 *
 * @author ohun@live.cn (夜色)
 */
public final class MyCallbackEventReceiver extends CallbackEventReceiver {
    private final Logger logger = LoggerFactory.getLogger(MyCallbackEventReceiver.class);

    @Override
    protected int onEvent(int eventType, String eventBody) throws Exception {
        logger.error("receiver event, eventType={}, eventBody={}", eventType, eventBody);
        return 0;
    }
}

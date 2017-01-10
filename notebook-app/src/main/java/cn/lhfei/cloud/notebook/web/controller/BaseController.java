/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.lhfei.cloud.notebook.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Dec 17, 2016
 */
@RequestMapping("")
public abstract class BaseController {
	protected Logger LOG = LoggerFactory.getLogger(this.getClass());
	protected Marker MARKER = MarkerFactory.getMarker("ctrl-");
	
	@GetMapping("/")
	protected String getProp(@RequestParam("q") String q) {
		
		return environment.getProperty(q);
	}
	
	@GetMapping("/apps/{app}")
	protected ModelAndView forward(@PathVariable("app") String app) {
		ModelAndView view = new ModelAndView(app +"/index");
		
		return view;
	}
	
	@Autowired
	private Environment environment;
}

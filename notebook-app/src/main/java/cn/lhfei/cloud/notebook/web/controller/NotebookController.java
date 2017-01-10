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

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.lhfei.cloud.notebook.domain.Notebook;
import cn.lhfei.cloud.notebook.repository.NotebookRepository;
import cn.lhfei.cloud.notebook.repository.NotebookSearchRepository;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Dec 17, 2016
 */
@Controller
@RequestMapping("notebook")
public class NotebookController extends BaseController {
	
	Gson gson = new Gson();
	
	/*@GetMapping("/notebooks/")
	public @ResponseBody List<Notebook> list(Map<String, Object> model) {
		List<Notebook> list = notebookRepository.findAll();
		
		return list;
	}*/
	
	@GetMapping("/id")
	public String generateId(){
		ServiceInstance localInstance = client.getLocalServiceInstance();
		return localInstance.getServiceId() + "-" + localInstance.getHost() + "-" + localInstance.getPort();
	}
	
	@PostMapping("/notebooks/")
	public @ResponseBody String list(Map<String, Object> model) {
		List<Notebook> list = notebookRepository.findAll();
		
		return gson.toJson(list);
	}

	/*@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> create(@RequestBody Notebook notebook) {
		notebookRepository.save(notebook);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("create", new Date());
		map.put("id", notebook.getId());
		
		return map;
	}
	
	
	@GetMapping(value = "/notebooks/search", params = "searchStr")
	public @ResponseBody List<Notebook> search(@RequestParam("jql") String searchStr) {
		
		LOG.info(MARKER, "== {} ==", searchStr);
		
		List<Notebook> list = notebookRepository.findAll();
		
		return list;
	}
	
	@RequestMapping(value = "/{notebookId:[aA0-zZ9]+}", params = "myParam != notebooks", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getNotebook(@PathVariable("notebookId") String notebookId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", notebookId);
		map.put("create", new Date());
		
		return map;
	}*/
	
	@Autowired
	DiscoveryClient client;

	@Autowired
	private NotebookSearchRepository searchRepository;
	@Autowired
	private NotebookRepository notebookRepository;

}

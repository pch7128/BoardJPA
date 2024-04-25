package com.ezenac.jpatest.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jpab")
public class BoardController {

	@Autowired
	private BoardSvc svc;
	
	
	@GetMapping("/addForm")
	public String addForm() {
		return "addForm";
	}
	
	@PostMapping("/input")
	@ResponseBody
	public Map<String,Object> inputBoard(Board b){
		
		boolean input=svc.addBoard(b);
		Map<String,Object> map = new HashMap<>();
		map.put("input", input);
		return map;
		
	}
	
	@GetMapping("/list")
	public String boardList(Model m) {
		
		List<Board> blist=svc.getList();
		m.addAttribute("blist", blist);
		return "boardList";
	}
	
	@GetMapping("/detail/{bnum}")
	public String boardDetail(@PathVariable int bnum, Model m) {
		
		Board b=svc.getBoard(bnum);
		m.addAttribute("b", b);
		return "boardDetail";
	}
	
	@GetMapping("/editForm/{bnum}")
	public String editForm(@PathVariable int bnum, Model m) {
		
		Board b=svc.getBoard(bnum);
		System.out.println(b.getBnum());
		m.addAttribute("b", b);
		return "boardEdit";
	}
	
	@PostMapping("/edit")
	@ResponseBody
	public Map<String,Object> boardEdit(Board b){
		
		boolean edit=svc.boardEdit(b);
		Map<String,Object> map = new HashMap<>();
		map.put("edit", edit);
		map.put("bnum", b.getBnum());
		 return map;
	}
	
	@PostMapping("/deleted")
	@ResponseBody
	public Map<String,Boolean> boardDelete(@RequestParam("bnum") int bnum){
		
		svc.boardDelete(bnum);
		Map<String,Boolean> map = new HashMap<>();
		map.put("deleted",true);
		return map;
	}
}

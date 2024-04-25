package com.ezenac.jpatest.board;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardSvc {

	@Autowired
	private BoardRepository re;
	
	public boolean addBoard(Board b) {
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String rate = sdf.format(now); 

		b.setRdate(rate);
		
		Board vo=re.save(b);
		if(vo!=null) return true;
		else return false;
	}
	
	
	public List<Board> getList(){
		
		List<Board> blist =re.findAll();
		return blist;
	}
	
	public Board getBoard(int bnum) {
		return re.findByBnum(bnum);
	}
	
	public boolean boardEdit(Board b) {
		Board vo=re.findById(b.getBnum()).get();
		vo.setTitle(b.getTitle());
		vo.setContents(b.getContents());

		return addBoard(vo);
	}
	
	public void boardDelete(int bnum) {
		re.deleteById(bnum);
	}
}

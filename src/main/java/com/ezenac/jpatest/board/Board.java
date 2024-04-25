package com.ezenac.jpatest.board;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="jpaboard")
public class Board {
	
	@Id
	@SequenceGenerator(sequenceName="SEQ_JPABOARD", allocationSize=1, name="SEQ_JPABOARD_GEN")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_JPABOARD_GEN")
	private int bnum;
	private String title;
	private String author;
	private String rdate;
	private String contents;

}

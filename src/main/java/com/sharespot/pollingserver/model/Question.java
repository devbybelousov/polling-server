package com.sharespot.pollingserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "question_of_survey")
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "question_id")
  private Long id;

  @Column(name = "text_of_question")
  private String question;

  @Column(name = "display_order")
  private int displayOrder;


  public Question(String question, int displayOrder) {
    this.question = question;
    this.displayOrder = displayOrder;
  }
}

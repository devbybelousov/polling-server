package com.sharespot.pollingserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "survey")
public class Survey {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "survey_id")
  private Long id;

  @Column(name = "title")
  private String title;

  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  @Column(name = "start_date")
  private Timestamp startDate;

  @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
  @Column(name = "end_date")
  private Timestamp endDate;

  @Column(name = "activity")
  private Boolean isActive;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "survey_id")
  private List<Question> questions;
}

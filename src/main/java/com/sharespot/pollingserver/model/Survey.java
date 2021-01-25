package com.sharespot.pollingserver.model;

import java.sql.Timestamp;
import java.util.Set;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "survey_id")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "start_date")
  private Timestamp startDate;

  @Column(name = "end_time")
  private Timestamp endDate;

  @Column(name = "activity")
  private Boolean isActive;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "survey_id")
  private Set<Question> questions;
}

package com.sharespot.pollingserver.payload;

import com.sharespot.pollingserver.model.Question;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRequest {

  private String title;
  private String startDate;
  private String endDate;
  private Boolean active;
  private List<Question> questions;
}

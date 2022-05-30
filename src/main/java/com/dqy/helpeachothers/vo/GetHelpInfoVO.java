package com.dqy.helpeachothers.vo;

import com.dqy.helpeachothers.entity.*;
import com.dqy.helpeachothers.util.HelpInfoPageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Repository
public class GetHelpInfoVO {
    List<GetHelpInfo> datas;
    HelpInfoPageUtil pageUtil;
}

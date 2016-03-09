package com.ecannetwork.dto.tech;

// Generated Jan 23, 2016 11:15:36 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.ecannetwork.core.module.db.dto.DtoSupport;

/**
 * MwVotesystem generated by hbm2java
 */
public class MwVotesystem extends DtoSupport implements java.io.Serializable
{

	private String id;
	private String CTitle;
	private Integer NOption;
	private Integer NPublic;
	private Integer NPublicStyle;
	private Date dtOverDate;
	private String CIprule;
	private Byte NScoreType;
	private String CReturnUrl;
	private String CLogicRule;
	private Byte NLogicType;
	private Integer NCodeSurvey;
	private Integer NLogicSurvey;
	private Integer NIphour;
	private Integer NCycNum;
	private Integer NRflag;
	private String CCycNum;
	private String CRflag;
	private Integer NIprecord;
	private Date dtStartDate;
	private String CTearcher;
	private String CAdrees;
	private String CCode;

	public MwVotesystem()
	{
	}

	public MwVotesystem(String CTitle, Integer NOption, Integer NPublic,
			Integer NPublicStyle, Date dtOverDate, String CIprule,
			Byte NScoreType, String CReturnUrl, String CLogicRule,
			Byte NLogicType, Integer NCodeSurvey, Integer NLogicSurvey,
			Integer NIphour, Integer NCycNum, Integer NRflag, String CCycNum,
			String CRflag, Integer NIprecord, Date dtStartDate,
			String CTearcher, String CAdrees, String CCode)
	{
		this.CTitle = CTitle;
		this.NOption = NOption;
		this.NPublic = NPublic;
		this.NPublicStyle = NPublicStyle;
		this.dtOverDate = dtOverDate;
		this.CIprule = CIprule;
		this.NScoreType = NScoreType;
		this.CReturnUrl = CReturnUrl;
		this.CLogicRule = CLogicRule;
		this.NLogicType = NLogicType;
		this.NCodeSurvey = NCodeSurvey;
		this.NLogicSurvey = NLogicSurvey;
		this.NIphour = NIphour;
		this.NCycNum = NCycNum;
		this.NRflag = NRflag;
		this.CCycNum = CCycNum;
		this.CRflag = CRflag;
		this.NIprecord = NIprecord;
		this.dtStartDate = dtStartDate;
		this.CTearcher = CTearcher;
		this.CAdrees = CAdrees;
		this.CCode = CCode;
	}

	public String getId()
	{
		return this.id;// DtoSupport.java中该方法为抽象方法，类型为String，但是该表字段为int，修改映射文件
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getCTitle()
	{
		return this.CTitle;
	}

	public void setCTitle(String CTitle)
	{
		this.CTitle = CTitle;
	}

	public Integer getNOption()
	{
		return this.NOption;
	}

	public void setNOption(Integer NOption)
	{
		this.NOption = NOption;
	}

	public Integer getNPublic()
	{
		return this.NPublic;
	}

	public void setNPublic(Integer NPublic)
	{
		this.NPublic = NPublic;
	}

	public Integer getNPublicStyle()
	{
		return this.NPublicStyle;
	}

	public void setNPublicStyle(Integer NPublicStyle)
	{
		this.NPublicStyle = NPublicStyle;
	}

	public Date getDtOverDate()
	{
		return this.dtOverDate;
	}

	public void setDtOverDate(Date dtOverDate)
	{
		this.dtOverDate = dtOverDate;
	}

	public String getCIprule()
	{
		return this.CIprule;
	}

	public void setCIprule(String CIprule)
	{
		this.CIprule = CIprule;
	}

	public Byte getNScoreType()
	{
		return this.NScoreType;
	}

	public void setNScoreType(Byte NScoreType)
	{
		this.NScoreType = NScoreType;
	}

	public String getCReturnUrl()
	{
		return this.CReturnUrl;
	}

	public void setCReturnUrl(String CReturnUrl)
	{
		this.CReturnUrl = CReturnUrl;
	}

	public String getCLogicRule()
	{
		return this.CLogicRule;
	}

	public void setCLogicRule(String CLogicRule)
	{
		this.CLogicRule = CLogicRule;
	}

	public Byte getNLogicType()
	{
		return this.NLogicType;
	}

	public void setNLogicType(Byte NLogicType)
	{
		this.NLogicType = NLogicType;
	}

	public Integer getNCodeSurvey()
	{
		return this.NCodeSurvey;
	}

	public void setNCodeSurvey(Integer NCodeSurvey)
	{
		this.NCodeSurvey = NCodeSurvey;
	}

	public Integer getNLogicSurvey()
	{
		return this.NLogicSurvey;
	}

	public void setNLogicSurvey(Integer NLogicSurvey)
	{
		this.NLogicSurvey = NLogicSurvey;
	}

	public Integer getNIphour()
	{
		return this.NIphour;
	}

	public void setNIphour(Integer NIphour)
	{
		this.NIphour = NIphour;
	}

	public Integer getNCycNum()
	{
		return this.NCycNum;
	}

	public void setNCycNum(Integer NCycNum)
	{
		this.NCycNum = NCycNum;
	}

	public Integer getNRflag()
	{
		return this.NRflag;
	}

	public void setNRflag(Integer NRflag)
	{
		this.NRflag = NRflag;
	}

	public String getCCycNum()
	{
		return this.CCycNum;
	}

	public void setCCycNum(String CCycNum)
	{
		this.CCycNum = CCycNum;
	}

	public String getCRflag()
	{
		return this.CRflag;
	}

	public void setCRflag(String CRflag)
	{
		this.CRflag = CRflag;
	}

	public Integer getNIprecord()
	{
		return this.NIprecord;
	}

	public void setNIprecord(Integer NIprecord)
	{
		this.NIprecord = NIprecord;
	}

	public Date getDtStartDate()
	{
		return this.dtStartDate;
	}

	public void setDtStartDate(Date dtStartDate)
	{
		this.dtStartDate = dtStartDate;
	}

	public String getCTearcher()
	{
		return this.CTearcher;
	}

	public void setCTearcher(String CTearcher)
	{
		this.CTearcher = CTearcher;
	}

	public String getCAdrees()
	{
		return this.CAdrees;
	}

	public void setCAdrees(String CAdrees)
	{
		this.CAdrees = CAdrees;
	}

	public String getCCode()
	{
		return this.CCode;
	}

	public void setCCode(String CCode)
	{
		this.CCode = CCode;
	}

}
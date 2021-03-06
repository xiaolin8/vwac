package com.ecannetwork.dto.tech;

// Generated Jan 23, 2016 11:15:36 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import com.ecannetwork.core.module.db.dto.DtoSupport;

/**
 * MwVotecourse generated by hbm2java
 */
public class MwVotecourse extends DtoSupport implements java.io.Serializable
{

	private String id;
	private String CTitle;
	private Date dtOverDate;
	private String CReturnUrl;
	private Integer NCodeSurvey;
	private Date dtStartDate;
	private String CTearcher;
	private String CAdrees;
	private String CCode;
	private Integer NSysId;
	private Integer NType;
	private String CCourse;
	private String pxnum;
	private Date courseStart;
	private Date courseEnd;

	public MwVotecourse()
	{
	}

	public MwVotecourse(String CTitle, Date dtOverDate, String CReturnUrl, Integer NCodeSurvey, Date dtStartDate, String CTearcher, String CAdrees, String CCode, Integer NSysId, Integer NType,
			String CCourse, String pxnum, Date courseStart, Date courseEnd)
	{
		this.CTitle = CTitle;
		this.dtOverDate = dtOverDate;
		this.CReturnUrl = CReturnUrl;
		this.NCodeSurvey = NCodeSurvey;
		this.dtStartDate = dtStartDate;
		this.CTearcher = CTearcher;
		this.CAdrees = CAdrees;
		this.CCode = CCode;
		this.NSysId = NSysId;
		this.NType = NType;
		this.CCourse = CCourse;
		this.pxnum = pxnum;
		this.courseStart = courseStart;
		this.courseEnd = courseEnd;
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

	public Date getDtOverDate()
	{
		return this.dtOverDate;
	}

	public void setDtOverDate(Date dtOverDate)
	{
		this.dtOverDate = dtOverDate;
	}

	public String getCReturnUrl()
	{
		return this.CReturnUrl;
	}

	public void setCReturnUrl(String CReturnUrl)
	{
		this.CReturnUrl = CReturnUrl;
	}

	public Integer getNCodeSurvey()
	{
		return this.NCodeSurvey;
	}

	public void setNCodeSurvey(Integer NCodeSurvey)
	{
		this.NCodeSurvey = NCodeSurvey;
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

	public Integer getNSysId()
	{
		return this.NSysId;
	}

	public void setNSysId(Integer NSysId)
	{
		this.NSysId = NSysId;
	}

	public Integer getNType()
	{
		return this.NType;
	}

	public void setNType(Integer NType)
	{
		this.NType = NType;
	}

	public String getCCourse()
	{
		return this.CCourse;
	}

	public void setCCourse(String CCourse)
	{
		this.CCourse = CCourse;
	}

	public String getPxnum()
	{
		return this.pxnum;
	}

	public void setPxnum(String pxnum)
	{
		this.pxnum = pxnum;
	}

	public Date getCourseStart()
	{
		return this.courseStart;
	}

	public void setCourseStart(Date courseStart)
	{
		this.courseStart = courseStart;
	}

	public Date getCourseEnd()
	{
		return this.courseEnd;
	}

	public void setCourseEnd(Date courseEnd)
	{
		this.courseEnd = courseEnd;
	}

}

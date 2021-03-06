﻿using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using MW;
using MW.Common;

namespace PortalWeb.mw.retailknowhow
{
    public partial class sktitemlist : System.Web.UI.Page
    {
        private MW.BLL.B_Sktitem bll = new MW.BLL.B_Sktitem();
        private MW.Model.M_Mw_sktitem model = new MW.Model.M_Mw_sktitem();
        protected int Id = 0, CId = 0, Type = 0;
        private string strWhere, SearchName;

        protected void Page_Load(object sender, EventArgs e)
        {
            SearchName = MW.Common.LYRequest.GetString("SearchName", true);
            Id = MW.Common.LYRequest.GetInt("Id", 0);
            CId = MW.Common.LYRequest.GetInt("CId", 0);
            Type = MW.Common.LYRequest.GetInt("Type", 0);
            if (!IsPostBack)
            {
                InitData();
                BindList();
            }
        }
        private void InitData()
        {
            //JBind.BindList(Drp_Province, bll.GetProvince(), "Name", "ID");//省份
            // Drp_Province.Items.Insert(0, new ListItem("请选择", "-1"));
        }
        private void BindList()
        {

            #region __________Where语句__________

            strWhere = "CId=" + CId + " and chapterid=" + Id;
            //strWhere = "1=1";
            //if (SearchName != "")
            //{
            //    strWhere += " and (C_Name like '%" + SearchName + "%')";
            //}
            #endregion

            rpt_List.PageLink = "sktitemlist.aspx?Search=Yes&type=" + Type + "&CId=" + CId + "&Id=" + Id + "&SearchName=" + Utils.UrlEncode(SearchName);
            rpt_List.PageSize = 15;
            rpt_List.CurrentPage = LYRequest.GetInt("page", 1);

            DataSet ds = MW.BLL.mw_getlistbypage.GetDataSet_NoCache("mw_sktitem", "*", strWhere, "", "ID DESC", "ID", rpt_List.CurrentPage, rpt_List.PageSize, 1);

            rpt_List.RecordCount = Convert.ToInt32(ds.Tables[0].Rows[0][0]);
            JBind.BindList(rpt_List, ds.Tables[1]);
        }
        //protected void btnSearch_Click(object sender, EventArgs p1)
        //{
        //    StringBuilder builder = new StringBuilder("sktitemlist.aspx?Search=Yes&type=" + Type + "&CId=" + CId + "&Id=" + Id);
        //    //builder.Append("&TypeId="+JBind.GetSelectedList(drpTypeId));

        //    if (!string.IsNullOrEmpty(this.txtSearchName.Text.Trim()))
        //    {
        //        builder.Append("&SearchName=" + this.txtSearchName.Text.Trim());
        //    }
        //    base.Response.Redirect(builder.ToString());
        //}
        protected void lbtnDeletes_Click(object sender, EventArgs p1)
        {
            if (BasePage.IsPermissions(0x6c))
            {
                //int num = 0;
                foreach (RepeaterItem item in this.rpt_List.Items)
                {
                    HtmlInputCheckBox box = (HtmlInputCheckBox)item.FindControl("cheId");
                    if (box.Checked)
                    {
                        bll.Delete(int.Parse(box.Value));
                        // num++;
                    }
                }
                base.Response.Redirect(HttpContext.Current.Request.Url.PathAndQuery);
            }
        }
        protected void rpt_List_ItemCommand(object source, RepeaterCommandEventArgs p1)
        {
            int num = int.Parse(p1.CommandArgument.ToString());
            if (p1.CommandName == "lbtnDelete")
            {

                bll.Delete(num);
                base.Response.Redirect(HttpContext.Current.Request.Url.PathAndQuery);
            }

        }
        protected void rpt_List_ItemDataBound(object sender, RepeaterItemEventArgs p1)
        {
            if ((p1.Item.ItemType == ListItemType.Item) || (p1.Item.ItemType == ListItemType.AlternatingItem))
            {
                Panel pan = (Panel)p1.Item.FindControl("panAdd");
                if (pan != null)
                {
                    DataRowView drv = (DataRowView)p1.Item.DataItem;
                    if (Type == 1)
                    {
                        if (drv["Parentid"].ToString() == "0" && drv["Parentid2"].ToString() == "0") pan.Visible = true;
                    }
                    else
                    {
                        pan.Visible = true;
                    }

                }

            }
        }
        protected string Character(int id)
        {
            if (id == 1)
            {
                return "绿";
            }
            else if (id == 2)
            {
                return "深绿";
            }
            else if (id == 3)
            {
                return "蓝";
            }
            else if (id == 4)
            {
                return "深蓝";
            }
            else if (id == 5)
            {
                return "橙";
            }

            return "";
        }
        protected string _Type(int id)
        {
            if (id == 1)
            {
                return "六边形";
            }
            else if (id == 2)
            {
                return "五边形";
            }
            else if (id == 3)
            {
                return "正方形";
            }
            else if (id == 4)
            {
                return "椭圆";
            }

            return "";
        }
    }
}
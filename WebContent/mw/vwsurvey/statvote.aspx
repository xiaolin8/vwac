﻿<%@ Page Title="" Language="C#" MasterPageFile="~/mw/Default.Master" AutoEventWireup="true" CodeBehind="StatVote.aspx.cs" Inherits="Plugin.VWSurvey.Admini.VWSurvey.StatVote" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style>*{ padding: 0px;}</style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
      <div id="h_main">
<%-- <asp:UpdatePanel ID="UpdatePanel1" runat="server">
            <contenttemplate>--%>
        <table border="0" cellspacing="0" style="width: 100%;">
            <tr class="daohang_title">
                <td style="text-align: left; padding-left: 3px;">
                    搜索条件↓
                </td>
                <td style="text-align: right; padding-right: 3px;">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="padding-top: 5px;">
                    <table border="0" cellpadding="0" cellspacing="1" style="margin-bottom: 15px;">
                            <tr>
                                <td class="td_content">
                                培训名称： 
                                <asp:TextBox runat="server" ID="txtSearchName"></asp:TextBox> 
                               &nbsp; 培训老师： 
                                <asp:TextBox runat="server" ID="txtTeacherName"></asp:TextBox></td></tr>
                            <tr>        <td class="td_content">
                                开始时间：
                                <asp:TextBox ID="txtBeginTime" runat="server" OnClick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"
                        SkinID="date" title="选择日期"></asp:TextBox>- <asp:TextBox ID="txtEndTime" runat="server" OnClick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})"
                        SkinID="date" title="选择日期"></asp:TextBox>&nbsp; 
                                显示：<asp:DropDownList runat="server" ID="drpSize">
                                       <asp:ListItem Value="10">10</asp:ListItem>
                                    <asp:ListItem Value="20" Selected="True">20</asp:ListItem>
                                    <asp:ListItem Value="50">50</asp:ListItem>
                                    <asp:ListItem Value="100">100</asp:ListItem>
                                   </asp:DropDownList>
                                &nbsp;&nbsp; <asp:Button ID="btnSearch" runat="server" Text="搜 索" CssClass="btn" OnClick="btnSearch_Click"
                                    ></asp:Button>
                                        </td>
                        </tr>
                         </table>
                </td>
            </tr>
       
            <tr class="daohang_title">
                <td style="text-align: left; padding-left: 3px;">
                    列表↓ 
                </td>
                <td></td>
            </tr>
            <tr>
                <td colspan="2">
                 <ctl:JRepeater ID="rpt_List" runat="server" OnItemCommand="rpt_List_ItemCommand">
                  <HeaderTemplate>
                    <table cellpadding="0" cellspacing="0" border="0" width="100%" id="tableData">
                        <tr>
                           
                             
                            <th>调查名称</th>
                         
                               <th>操作</th>
                        </tr>
            </HeaderTemplate>
                            <ItemTemplate>
                                <tr class="tr_data" onmouseout="mout(this);" onmouseover="mover(this);">
                                
                                    <td>
                                    <%# Eval("C_Title") %>
                                    </td>
                                    <td>
                                        <a href="statresult.aspx?id=<%#Eval("id") %>&VoteId=<%#Eval("N_SysId") %>">分析结果</a>
                                         <a href="statreport.aspx?id=<%#Eval("id") %>&VoteId=<%#Eval("N_SysId") %>">图形报表</a>
                                        <a target="_blank" href="voteexport.aspx?id=<%#Eval("id") %>&VoteId=<%#Eval("N_SysId") %>">导出总表到Excel</a>
                                        <a target="_blank" href="voteexportdetsail.aspx?id=<%#Eval("id") %>&VoteId=<%#Eval("N_SysId") %>">按单人导出到Excel</a>
                                         <asp:LinkButton ID="lbtnToExcel" Visible="False" CommandName="lbtnToExcel" CommandArgument='<%#Eval("Id")+"|"+Eval("N_SysId")%>'
                                             OnClientClick="return confirm('确定导出到Excel吗？')" runat="server">导出到Excel</asp:LinkButton>

                                    </td>
                                   </tr>
                            </ItemTemplate>
                        <FooterTemplate>
                </table>
            </FooterTemplate>
         </ctl:JRepeater>
                </td>
            </tr>
        </table>
       <%--  </contenttemplate>
        </asp:UpdatePanel>--%>
       </div>
</asp:Content>

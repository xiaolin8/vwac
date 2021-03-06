﻿<%@ Page Title="" Language="C#" MasterPageFile="~/mw/Default.Master" AutoEventWireup="true" CodeBehind="VoteList.aspx.cs" Inherits="Plugin.VWSurvey.Admini.VWSurvey.VoteList" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <style>*{ padding: 0px;}</style>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div id="h_main">
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
                    <table border="0" cellpadding="0" cellspacing="1" style="margin-bottom: 15px;width: 100%;">
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
                        SkinID="date" title="选择日期" OnTextChanged="txtEndTime_TextChanged"></asp:TextBox>&nbsp; 
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
                 <td style="text-align: right; padding-right: 3px;">
                     <input id="btnAdd" type="button" value="新 增" class="btnlistOver" onclick="javascript:location.href='biceoption.aspx';" />
                  
                </td>
                    
            </tr>
            <tr>
                <td colspan="2">
                 <ctl:JRepeater ID="rpt_List" runat="server" OnItemCommand="rpt_List_ItemCommand" >
                  <HeaderTemplate>
                    <table cellpadding="0" cellspacing="0" border="0" width="100%" id="tableData">
                        <tr>
                          <th> <%--<input id="cheList" type="checkbox" onclick="checkAll(this.form)" />--%></th>

                            <th>调查名称</th>
                                
                            <th>开始日期</th>
                                
                            <th>结束日期</th>
                            <th style="width: 260px;">操作</th>
                        </tr>
                       </HeaderTemplate>
                            <ItemTemplate>
                                <tr class="tr_data" onmouseout="mout(this);" onmouseover="mover(this);">
                                    <td>
                                       <%-- <input id="cheId" runat="server" value='<%#Eval("N_SysId")%>' type="checkbox" />--%></td>
                                    <td>
                                         <a href="/onlinesurvey/<%#Eval("Id") %>.html" target="_blank">  <%# Eval("C_Title") %></a>
                                    </td>
                                    <td>
                                    <%# MW.Common.Utils.GetStandardDate(Eval("DT_StartDate").ToString())%>
                                    </td>
          <td><%# MW.Common.Utils.GetStandardDate(Eval("DT_OverDate").ToString())%>
                                    </td>
                                    <td>
                                       <a href="biceoption.aspx?&Id=<%# Eval("Id") %>"> 编辑</a>

                                         <asp:LinkButton ID="lbtnCopy" CommandName="lbtnCopy" CommandArgument='<%#Eval("Id")%>'
                                            title="复制" OnClientClick="return confirm('确定复制投票项目吗？')" runat="server" CssClass="smallbutton">复制</asp:LinkButton>
                                        
                                        <asp:LinkButton  ID="lbtnDelete" CommandName="lbtnDelete" CommandArgument='<%#Eval("Id")%>'
                                            title="删除" OnClientClick="return confirm('确定删除数据吗？')" runat="server">删除</asp:LinkButton>
                                        <asp:LinkButton  ID="lbtnBuild" CommandName="lbtnBuild" CommandArgument='<%#Eval("Id")+"|"+Eval("N_SysId") %>'
                                            title="生成问卷" OnClientClick="return confirm('确定要生成问卷吗？')" runat="server">生成问卷</asp:LinkButton> 
                                        <a class="smallbutton" href="javascript:void(0)" onclick="javascript:view('发布问卷','surveypub.aspx?id=<%#Eval("id") %>&SysId=<%#Eval("N_SysId") %>');">发布问卷</a>
                                        <%-- <a class="smallbutton" href="styledetail.aspx?id=<%#Eval("id") %>&SysId=<%#Eval("N_SysId") %>">样式编辑</a>--%>
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
       </div>
    <script>
        function modify(name,url) {
            $.layer({
                type: 2,
                border: [0],
                title: false,
                shadeClose: true,
                closeBtn: false,
                iframe: { src: url },
                area: ['860px', '400px']
            });
        }
        function view(name, url) {
            $.layer({
                type: 2,
                border: [0],
                title: false,
                shadeClose: true,
                closeBtn: [0, false],
                iframe: { src: url },
                area: ['860px', '400px']
            });
        }
    </script>
</asp:Content>

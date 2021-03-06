package com.ecannetwork.core.util;

import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <ul>
 * <li><b>目的:</b> <br />
 * <p>
 * 邮件发送公共类
 * </p>
 * </li>
 * <li><b>采用的不变量：</b></li>
 * <li><b>并行策略：</b></li>
 * <li><b>使用示例</b><br />
 * 
 * <pre></li>
 * <li><b>调用例子：
 * 
 * <pre>
 * </pre>
 * 
 * </b></li>
 * 
 * </ul>
 */
public class MailUtil
{
	private static Log log = LogFactory.getLog(MailUtil.class);

	// smtp服务器
	private String smtp;

	// smtp服务器用户名
	private String user;

	// 发送方密码
	private String password;

	private Transport trans;

	private Session session;

	/**
	 * 构造函数
	 */
	public MailUtil()
	{

	}

	public MailUtil(String smtp, String user, String password)
	{
		this.smtp = smtp;
		this.user = user;
		this.password = password;
		log.info("smtp:" + this.smtp + "\tuser:" + this.user + "\tpasswd:"
				+ this.password);
	}

	/**
	 * <p>
	 * <b>业务处理描述</b>
	 * <ul>
	 * <li>可见性原因：需要被其他应用调用</li>
	 * <li>目的：连接SMTP服务器</li>
	 * <li>适用的前提条件:</li>
	 * <li>后置条件：</li>
	 * <li>例外处理：无</li>
	 * <li>已知问题：</li>
	 * <li>调用的例子：</li>
	 * </ul>
	 * </p>
	 * 
	 * @return
	 * @throws MessagingException
	 */
	public MailUtil connect() throws MessagingException
	{
		log.info("smtp=" + smtp);
		log.info("user=" + user);
		log.info("password=" + password);

		if (session == null)
		{
			Properties props = new Properties();
			props.put("mail.smtp.host", smtp);
			props.put("mail.smtp.auth", "true");
			// Get session
			session = Session.getDefaultInstance(props, null);
			// watch the mail commands go by to the mail server
			session.setDebug(true);
		}

		if (trans == null)
		{
			trans = session.getTransport("smtp");
		}

		if (!trans.isConnected())
		{
			trans.connect(smtp, user, password);
		}

		return this;
	}

	public void disConnect()
	{
		if (trans != null && trans.isConnected())
		{
			try
			{
				trans.close();
			} catch (MessagingException e)
			{
				// Do nothing.
			}
		}
	}

	/**
	 * 
	 * @param from
	 *            发送人email
	 * @param to
	 *            接收人email
	 * @param subject
	 *            主题
	 * @param text
	 *            内容
	 * @throws MessagingException
	 */
	public MailUtil sendEmail(String from, String to, String subject,
			String text, String encoding) throws MessagingException
	{
		String[] filenames = new String[0];
		return sendEmail(from, to, subject, text, filenames, encoding);
	}

	/**
	 * <p>
	 * <b>业务处理描述</b>
	 * <ul>
	 * <li>可见性原因：需要被其他应用调用</li>
	 * <li>目的：发送邮件</li>
	 * <li>适用的前提条件:已调用connect</li>
	 * <li>后置条件：发送完成后请关闭连接</li>
	 * <li>例外处理：无</li>
	 * <li>已知问题：</li>
	 * <li>调用的例子：</li>
	 * </ul>
	 * </p>
	 * 
	 * @param from
	 *            发送人email
	 * @param to
	 *            接收人email
	 * @param subject
	 *            主题
	 * @param text
	 *            内容
	 * @param filename
	 *            附件
	 * @throws MessagingException
	 */
	public MailUtil sendEmail(String from, String to, String subject,
			String text, String filename, String encoding)
			throws MessagingException
	{
		String[] filenames = new String[1];
		filenames[0] = filename;
		return sendEmail(from, to, subject, text, filenames, encoding);
	}

	/**
	 * <p>
	 * <b>业务处理描述</b>
	 * <ul>
	 * <li>可见性原因：需要被其他应用调用</li>
	 * <li>目的：发送邮件</li>
	 * <li>适用的前提条件:已调用connect</li>
	 * <li>后置条件：发送完成后请关闭连接</li>
	 * <li>例外处理：无</li>
	 * <li>已知问题：</li>
	 * <li>调用的例子：</li>
	 * </ul>
	 * </p>
	 * 
	 * @param from
	 *            发送人email
	 * @param to
	 *            接收人email
	 * @param subject
	 *            主题
	 * @param text
	 *            内容
	 * @param filename
	 *            附件
	 * @throws MessagingException
	 */
	public MailUtil sendEmail(String from, String to, String subject,
			String text, String[] filenames, String encoding)
			throws MessagingException
	{
		// Define message
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));
		InternetAddress[] toAddress =
		{ new InternetAddress(to) };

		msg.setRecipients(Message.RecipientType.TO, toAddress);
		msg.setHeader("X-Mailer", "Cashing send mailer Ver 1.0");
		msg.setSubject(subject);

		// 创建 Mimemultipart，这是包含多个附件是必须创建的。
		MimeMultipart multi = new MimeMultipart();

		// 创建
		// BodyPart，主要作用是将以后创建的n个内容加入MimeMultipart;第一个BodyPart.主要写一些一般的信件内容。
		BodyPart textBodyPart = new MimeBodyPart();

		// 发送内容：可以HTML
		textBodyPart.setContent(text, "text/html;charset=" + encoding);

		// 压入第一个BodyPart到MimeMultipart对象中。
		multi.addBodyPart(textBodyPart);

		if (filenames != null && filenames.length > 0)
		{
			// 添加文件
			for (int i = 0; i < filenames.length; i++)
			{
				if (filenames[i] == null || "".equals(filenames[i]))
				{
					continue;
				}
				// 创建BodyPart,是一个FileDAtaSource
				FileDataSource fds = new FileDataSource(filenames[i]);
				BodyPart fileBodyPart = new MimeBodyPart();
				// 字符流形式装入文件
				fileBodyPart.setDataHandler(new DataHandler(fds));

				// 设置文件名，可以不是原来的文件名。
				try
				{
					fileBodyPart.setFileName(MimeUtility.encodeWord(
							fds.getName(), encoding, null));
				} catch (Exception e)
				{
				}

				multi.addBodyPart(fileBodyPart);
			}
		}

		msg.setContent(multi);

		msg.setSentDate(Calendar.getInstance().getTime());

		// Send email
		msg.saveChanges();
		trans.sendMessage(msg, msg.getAllRecipients());
		return this;
	}

	/**
	 * @return the smtp
	 */
	public String getSmtp()
	{
		return smtp;
	}

	/**
	 * @param smtp
	 *            the smtp to set
	 */
	public void setSmtp(String smtp)
	{
		this.smtp = smtp;
	}

	/**
	 * @return the user
	 */
	public String getUser()
	{
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user)
	{
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the trans
	 */
	public Transport getTrans()
	{
		return trans;
	}

	/**
	 * @param trans
	 *            the trans to set
	 */
	public void setTrans(Transport trans)
	{
		this.trans = trans;
	}

	public static void main(String args[])
	{
		try
		{
			new MailUtil("smtp.sinovatech.com", "username", "password")
					.connect()
					.sendEmail("liulibin@sinovatech.com",
							"liulibin@sinovatech.com", "标题", "内容", "gbk")
					.disConnect();

			log.info("send success!");
		} catch (MessagingException e)
		{
			e.printStackTrace();
		}
	}
}

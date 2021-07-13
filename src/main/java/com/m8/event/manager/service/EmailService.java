package com.m8.event.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender sender;
    
    @Value("${spring.mail.username}")
    private String from;

    public void mandarAlgo(String para, String asunto, String cuerpo, String usuario, String tituloEvento, String rol) throws MessagingException {

        new Thread(() -> {

            try{
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(from);
            helper.setTo(para);
            helper.setSubject(asunto);
            helper.setText("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
                    "<meta name=\"x-apple-disable-message-reformatting\">\n" +
                    "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "<meta content=\"telephone=no\" name=\"format-detection\">\n" +
                    "<title>Nuevo mensaje</title>\n" +
                    "<!--[if (mso 16)]>\n" +
                    "<style type=\"text/css\">\n" +
                    "a {text-decoration: none;}\n" +
                    "</style>\n" +
                    "<![endif]-->\n" +
                    "<!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]-->\n" +
                    "<!--[if gte mso 9]>\n" +
                    "<xml>\n" +
                    "<o:OfficeDocumentSettings>\n" +
                    "<o:AllowPNG></o:AllowPNG>\n" +
                    "<o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                    "</o:OfficeDocumentSettings>\n" +
                    "</xml>\n" +
                    "<![endif]-->\n" +
                    "<!--[if !mso]><!-- -->\n" +
                    "<link href=\"https://fonts.googleapis.com/css?family=Merriweather:400,400i,700,700i\" rel=\"stylesheet\">\n" +
                    "<link href=\"https://fonts.googleapis.com/css?family=Merriweather+Sans:400,400i,700,700i\" rel=\"stylesheet\">\n" +
                    "<link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,700i\" rel=\"stylesheet\">\n" +
                    "<!--<![endif]-->\n" +
                    "<style type=\"text/css\">\n" +
                    "#outlook a {\n" +
                    "padding:0;\n" +
                    "}\n" +
                    ".ExternalClass {\n" +
                    "width:100%;\n" +
                    "}\n" +
                    ".ExternalClass,\n" +
                    ".ExternalClass p,\n" +
                    ".ExternalClass span,\n" +
                    ".ExternalClass font,\n" +
                    ".ExternalClass td,\n" +
                    ".ExternalClass div {\n" +
                    "line-height:100%;\n" +
                    "}\n" +
                    ".es-button {\n" +
                    "mso-style-priority:100!important;\n" +
                    "text-decoration:none!important;\n" +
                    "}\n" +
                    "a[x-apple-data-detectors] {\n" +
                    "color:inherit!important;\n" +
                    "text-decoration:none!important;\n" +
                    "font-size:inherit!important;\n" +
                    "font-family:inherit!important;\n" +
                    "font-weight:inherit!important;\n" +
                    "line-height:inherit!important;\n" +
                    "}\n" +
                    ".es-desk-hidden {\n" +
                    "display:none;\n" +
                    "float:left;\n" +
                    "overflow:hidden;\n" +
                    "width:0;\n" +
                    "max-height:0;\n" +
                    "line-height:0;\n" +
                    "mso-hide:all;\n" +
                    "}\n" +
                    "[data-ogsb] .es-button {\n" +
                    "border-width:0!important;\n" +
                    "padding:15px 30px 15px 30px!important;\n" +
                    "}\n" +
                    "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1 { font-size:32px!important; text-align:left; line-height:120%!important } h2 { font-size:26px!important; text-align:left; line-height:120%!important } h3 { font-size:20px!important; text-align:left; line-height:120%!important } h1 a { text-align:left } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:36px!important } h2 a { text-align:left } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:30px!important } h3 a { text-align:left } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:18px!important } .es-menu td a { font-size:16px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:16px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:16px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:16px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:12px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:16px!important; display:inline-block!important; border-width:15px 30px 15px 30px!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0!important } .es-m-p0r { padding-right:0!important } .es-m-p0l { padding-left:0!important } .es-m-p0t { padding-top:0!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-m-p5 { padding:5px!important } .es-m-p5t { padding-top:5px!important } .es-m-p5b { padding-bottom:5px!important } .es-m-p5r { padding-right:5px!important } .es-m-p5l { padding-left:5px!important } .es-m-p10 { padding:10px!important } .es-m-p10t { padding-top:10px!important } .es-m-p10b { padding-bottom:10px!important } .es-m-p10r { padding-right:10px!important } .es-m-p10l { padding-left:10px!important } .es-m-p15 { padding:15px!important } .es-m-p15t { padding-top:15px!important } .es-m-p15b { padding-bottom:15px!important } .es-m-p15r { padding-right:15px!important } .es-m-p15l { padding-left:15px!important } .es-m-p20 { padding:20px!important } .es-m-p20t { padding-top:20px!important } .es-m-p20r { padding-right:20px!important } .es-m-p20l { padding-left:20px!important } .es-m-p25 { padding:25px!important } .es-m-p25t { padding-top:25px!important } .es-m-p25b { padding-bottom:25px!important } .es-m-p25r { padding-right:25px!important } .es-m-p25l { padding-left:25px!important } .es-m-p30 { padding:30px!important } .es-m-p30t { padding-top:30px!important } .es-m-p30b { padding-bottom:30px!important } .es-m-p30r { padding-right:30px!important } .es-m-p30l { padding-left:30px!important } .es-m-p35 { padding:35px!important } .es-m-p35t { padding-top:35px!important } .es-m-p35b { padding-bottom:35px!important } .es-m-p35r { padding-right:35px!important } .es-m-p35l { padding-left:35px!important } .es-m-p40 { padding:40px!important } .es-m-p40t { padding-top:40px!important } .es-m-p40b { padding-bottom:40px!important } .es-m-p40r { padding-right:40px!important } .es-m-p40l { padding-left:40px!important } }\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body style=\"width:100%;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
                    "<div class=\"es-wrapper-color\" style=\"background-color:#79646F\">\n" +
                    "<!--[if gte mso 9]>\n" +
                    "<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                    "<v:fill type=\"tile\" color=\"#79646f\" origin=\"0.5, 0\" position=\"0.5, 0\"></v:fill>\n" +
                    "</v:background>\n" +
                    "<![endif]-->\n" +
                    "<table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#79646F\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                    "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                    "<table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"left\" style=\"Margin:0;padding-left:10px;padding-right:10px;padding-top:15px;padding-bottom:15px\">\n" +
                    "<!--[if mso]><table style=\"width:580px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:282px\" valign=\"top\"><![endif]-->\n" +
                    "<table class=\"es-left\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"left\" style=\"padding:0;Margin:0;width:282px\">\n" +
                    "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td class=\"es-infoblock es-m-txt-c\" align=\"left\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica\\ neue', helvetica, sans-serif;line-height:14px;color:#CCCCCC;font-size:12px\">Notificación enviada automáticamente.</p></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:278px\" valign=\"top\"><![endif]-->\n" +
                    "<table class=\"es-right\" cellspacing=\"0\" cellpadding=\"0\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"left\" style=\"padding:0;Margin:0;width:278px\">\n" +
                    "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"right\" class=\"es-infoblock es-m-txt-c\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:14px;color:#CCCCCC;font-size:12px\">Ver en navegador</p></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<!--[if mso]></td></tr></table><![endif]--></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
                    "<tr style=\"border-collapse:collapse\"></tr>\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                    "<table class=\"es-header-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;background-repeat:no-repeat;width:600px;background-image:url(https://lwimki.stripocdn.email/content/guids/CABINET_e9f1fe9d87cba350b8370259305e607e/images/76431626144860377.png);background-position:center 80%\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" background=\"https://lwimki.stripocdn.email/content/guids/CABINET_e9f1fe9d87cba350b8370259305e607e/images/76431626144860377.png\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"left\" style=\"padding:0;Margin:0\">\n" +
                    "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\n" +
                    "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td class=\"es-m-txt-c\" align=\"center\" style=\"padding:0;Margin:0;padding-top:20px\"><h1 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:36px;font-style:normal;font-weight:bold;color:#ffffff\">.evn</h1></td>\n" +
                    "</tr>\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:15px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#FFFFFF;font-size:14px\">Event Manager</p></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                    "<table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:35px;padding-left:35px;padding-right:35px\">\n" +
                    "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:530px\">\n" +
                    "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'merriweather sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:57px;color:#333333;font-size:38px\">¡Hola!&nbsp;</p></td>\n" +
                    "</tr>\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'merriweather sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:32px;color:#333333;font-size:21px\">&nbsp;Tenemos una notificación para vos.&nbsp;</p></td>\n" +
                    "</tr>\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:20px;Margin:0;font-size:0\">\n" +
                    "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td style=\"padding:0;Margin:0;border-bottom:1px solid #cccccc;background:none;height:1px;width:100%;margin:0px\"></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                    "<table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:35px;padding-right:35px\">\n" +
                    "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:530px\">\n" +
                    "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0;padding-top:5px;padding-bottom:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:26px;color:#333333;font-size:17px\"><strong>"+cuerpo+"</strong></p></td>\n" +
                    "</tr>\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"right\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:23px;color:#333333;font-size:15px\"><i>Saludos,<br>"+usuario+".</i></p></td>\n" +
                    "</tr>\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:30px;Margin:0;font-size:0\">\n" +
                    "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td style=\"padding:0;Margin:0;border-bottom:1px solid #cccccc;background:none;height:1px;width:100%;margin:0px\"></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                    "<table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:15px;padding-left:35px;padding-right:35px\">\n" +
                    "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:530px\">\n" +
                    "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:5px;Margin:0;font-size:0\">\n" +
                    "<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td style=\"padding:0;Margin:0;border-bottom:0px solid #cccccc;background:none;height:1px;width:100%;margin:0px\"></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table class=\"es-footer\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
                    "<tr style=\"border-collapse:collapse\"></tr>\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                    "<table class=\"es-footer-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;background-repeat:no-repeat;width:600px;background-image:url(https://lwimki.stripocdn.email/content/guids/CABINET_e9f1fe9d87cba350b8370259305e607e/images/38521626145499510.png);background-position:82% 15%\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" background=\"https://lwimki.stripocdn.email/content/guids/CABINET_e9f1fe9d87cba350b8370259305e607e/images/38521626145499510.png\" bgcolor=\"#FFFFFF\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"left\" style=\"padding:0;Margin:0\">\n" +
                    "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:600px\">\n" +
                    "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:15px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;font-size:14px\"><br></p></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "<table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                    "<table class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:35px;padding-right:35px\">\n" +
                    "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:530px\">\n" +
                    "<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                    "<tr style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:17px;color:#ffffff;font-size:11px\"><strong>"+usuario+"("+rol+")</strong>&nbsp;de <strong>"+tituloEvento+"</strong>,&nbsp;al que te encontrás registrado con este email envió&nbsp;este mensaje desde la App.<br></p></td>\n" +
                    "</tr>\n" +
                    "<tr class=\"es-mobile-hidden\" style=\"border-collapse:collapse\">\n" +
                    "<td align=\"center\" class=\"es-m-p20t\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:14px;color:#ffffff;font-size:9px\">EventManager® 2021 - M8 Egg</p></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table></td>\n" +
                    "</tr>\n" +
                    "</table>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>",true);

            sender.send(message);


            }catch(Exception e){
                System.out.println("SE ROMPIO EL MAILSENDER. DETALLES:"+e.getMessage());
            }

        }).start();



    }




}
package projects.Personal.DataBreach.service;


import com.mailgun.api.v3.MailgunMessagesApi;
import com.mailgun.client.MailgunClient;
import com.mailgun.model.message.Message;
import com.mailgun.model.message.MessageResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

@Service
public class NotificationService
{
    private static CredentialService credentialService;
    Dotenv dotenv = Dotenv.load();
    public MessageResponse EmailNotificationById(Long id){

                MailgunMessagesApi mailgunMessagesApi = MailgunClient.config(dotenv.get("MAIL.API.KEY"))
                        .createApi(MailgunMessagesApi.class);

                String hostDomain = dotenv.get("MAIL.DOMAIN");

                //pull credential from database
            String credentialEmail = credentialService.findCredentialById(id).toString();

                Message message = Message.builder()
                        .from("Data Breach Monitoring" + hostDomain)
                        .to(credentialEmail)
                        .subject("Notice - Your Credentials Have Been Compromised")
                        .text("Your password for the email address: " + credentialEmail +
                                " is present in one or more leaked password dumps online. Please change it ASAP")
                        .build();
                return mailgunMessagesApi.sendMessage(dotenv.get("MAIL.DOMAIN"), message);


        }


}

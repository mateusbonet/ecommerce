package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class EmailService {

    public static void main(String[] args) {
        var emailService = new EmailService();
        try(var service = new KafkaService( EmailService.class.getSimpleName(),
                "ECOMMERCE_SEND_EMAIL",
                emailService::parse,
                String.class,
                Map.of())) {

            service.run();
        }
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("Send email!");
        System.out.println("Chave: " + record.key());
        System.out.println("Valor: " + record.value());
        System.out.println("Partition: " + record.partition());
        System.out.println("Offset: " + record.offset());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Email send!");
    }


}

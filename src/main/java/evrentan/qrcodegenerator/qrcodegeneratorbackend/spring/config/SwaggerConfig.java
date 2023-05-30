package evrentan.qrcodegenerator.qrcodegeneratorbackend.spring.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  /**
   * Controller Path static value in String type.
   */
  private static final String CONTROLLER_PATH = "evrentan.qrcodegenerator.qrcodegeneratorbackend.controller";

  /**
   * Bean declaration for Swagger Documentation details.
   *
   * @return OpenAPI. Please, see the {@link OpenAPI} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Bean
  public OpenAPI swaggerDocumentation() {
    Contact contact = new Contact();
    contact.setName("Evren Tan");
    contact.setEmail("info@evrentan.com");
    contact.setUrl("https://evrentan.com");
    return new OpenAPI()
        .info(new Info().title("Swagger UI")
            .description("QR Code Generator Swagger UI")
            .version("1.0.0")
            .contact(contact)
            .license(new License().name("Apache 2.0").url("http://springdoc.org")))
        .externalDocs(new ExternalDocumentation()
            .description("QR Code Generator Swagger UI"));
  }

  /**
   * Bean declaration for Swagger documentation details for all APIs within the {@link SwaggerConfig#CONTROLLER_PATH} field.
   *
   * @return GroupedOpenAPI. Please, see the {@link GroupedOpenApi} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Bean
  public GroupedOpenApi allApi() {
    return GroupedOpenApi.builder()
        .group("all-api")
        .packagesToScan(CONTROLLER_PATH)
        .build();
  }

  /**
   * Bean declaration for Swagger documentation details for all APIs within the {@link SwaggerConfig#CONTROLLER_PATH} field and matching "/qrCode/**" end-points.
   *
   * @return GroupedOpenAPI. Please, see the {@link GroupedOpenApi} class for details.
   *
   * @author <a href="https://github.com/evrentan">Evren Tan</a>
   * @since 1.0.0
   */
  @Bean
  public GroupedOpenApi qrCodeApi() {
    return GroupedOpenApi.builder()
        .group("qr-code-generator-api")
        .packagesToScan(CONTROLLER_PATH)
        .pathsToMatch("/qrCode/**")
        .build();
  }
}
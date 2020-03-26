package com.example.demo;

import com.bol.crypt.CryptVault;
import com.bol.secure.CachedEncryptionEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Configuration
public class EncryptionDBConfiguration {
    // TODO: wire this
    private static final byte[] secretKey = Base64.getDecoder().decode("hqHKBLV83LpCqzKpf8OvutbCs+O5wX5BPu3btWpEvXA=");

    @Bean
    public CryptVault cryptVault() {
        return new CryptVault()
                .with256BitAesCbcPkcs5PaddingAnd128BitSaltKey(0, secretKey);
    }

    @Bean
    public CachedEncryptionEventListener encryptionEventListener(CryptVault cryptVault) {
        return new CachedEncryptionEventListener(cryptVault);
    }
}

package com.funkey.notenook.repositories;

import com.funkey.notenook.models.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}

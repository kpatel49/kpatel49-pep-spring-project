package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message createMessage(Message message){
        return messageRepository.save(message);
    }

    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    public Message getMessageById(Integer messageId){
        return messageRepository.findById(messageId).orElse(null);
    }

    public boolean deleteMessage(Integer messageId){
        if(messageRepository.existsById(messageId)){
            messageRepository.deleteById(messageId);
            return true;
        }
        return false;
    }

    public int updateMessage(Integer messageId, String newText){
        Message message = getMessageById(messageId);
        if(message != null){
            message.setMessageText(newText);
            messageRepository.save(message);
            return 1;
        }
        return 0;
    }

    public List<Message> getMessagesByUser(Integer accountId){
        return messageRepository.findByPostedBy(accountId);
    }
}

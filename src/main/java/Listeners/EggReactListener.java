package Listeners;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Use case (?) that reacts to messages either sent by Kai or contains the trigger phrases with an egg emoji
 */
public class EggReactListener extends ListenerAdapter {
    private final String[] defaultTriggers = {"kai", "mapleopolis", "egg", "\uD83E\uDD5A"};
    private final List<String> triggers;
    private String kaiID;

    public EggReactListener(String kaiID){
        this.kaiID = kaiID;
        this.triggers = new ArrayList<>(Arrays.asList(defaultTriggers));
    }

    /**
     * Returns an instance of this use case, but with the specified triggers
     * @param kaiID ID of the person to harass >:) (will trigger for all their messages)
     * @param triggers List of strings that represents the trigger phrases, not case-sensitive
     */
    public EggReactListener(String kaiID, List<String> triggers){
        this.kaiID = kaiID;
        this.triggers = triggers;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if (event.getAuthor().getId().equals(kaiID)){
            eggReact(event);
            return;
        }

        for (String trigger : triggers){
            if (event.getMessage().getContentDisplay().toLowerCase().contains(trigger)){
                eggReact(event);
                return;
            }
        }

    }

    private void eggReact(MessageReceivedEvent event) {
        if (Math.random()>0.95) {
            event.getMessage().addReaction(Emoji.fromUnicode("\uD83E\uDD5A")).queue();
        }
    }
}

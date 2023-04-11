package musicmain;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.AbstractButton;

import sun.audio.*;

public class musicplayer implements ActionListener {
	AudioStream as;
	JButton play=new JButton("play");
	JButton stop=new JButton("stop");
	JButton pause=new JButton("pause");
	public static void main(String arg[])
	{
		new musicplayer().createGui();
	}
	public void createGui()
	{
		JFrame fm=new JFrame("Music Player");
		
		fm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fm.setLayout(new GridLayout(1,40,40,40));
		fm.add(play);
		fm.add(stop);
		fm.add(pause);
		fm.pack();
		fm.setVisible(true);
		play.addActionListener(this);
		stop.addActionListener(this);
		pause.addActionListener(this);
		try {
		as =new AudioStream(this.getClass().getResourceAsStream("/Linkin_Park_-_One_More_Light_(Lyrics___Lyric_Video).mp3"));
		}  catch(IOException e) {}
	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		if(arg0.getSource()==play) {
			AudioPlayer.player.start(as);
		}
		else	if(arg0.getSource()==stop) {
			AudioPlayer.player.stop(as);
			
			try {
		as =new AudioStream(this.getClass().getResourceAsStream("/Linkin_Park_-_One_More_Light_(Lyrics___Lyric_Video).mp3"));
				}  catch(IOException e) {}
			}
		else {   AudioPlayer.player.stop(as);   }
		
	}

}

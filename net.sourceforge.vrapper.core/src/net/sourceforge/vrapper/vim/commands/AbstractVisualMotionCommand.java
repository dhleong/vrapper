package net.sourceforge.vrapper.vim.commands;

import net.sourceforge.vrapper.vim.EditorAdaptor;
import net.sourceforge.vrapper.vim.commands.motions.Motion;

public abstract class AbstractVisualMotionCommand extends MotionCommand {

    public AbstractVisualMotionCommand(Motion motion) {
        super(motion);
    }

    protected abstract void extendSelection(EditorAdaptor editorAdaptor, Selection oldSelection);

    protected abstract Selection getSelection(EditorAdaptor editorAdaptor);

    @Override
    public void execute(EditorAdaptor editorAdaptor, int count)
            throws CommandExecutionException {
            	Selection oldSelection = getSelection(editorAdaptor);
            	editorAdaptor.setPosition(oldSelection.getTo(), false);
            	super.execute(editorAdaptor, count);
            	extendSelection(editorAdaptor, oldSelection);
            }

}
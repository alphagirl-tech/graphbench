package org.apache.giraph.io.formats;

/*
This class is adjusted according to the output generated by Green-Marl compiler
*/

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class BCMessage implements Writable {
	public BCMessage() {
	}

	public byte m_type;

	public BCMessage(byte type) {
		m_type = type;
	}

	// union of all message fields
	public long l0;
	public float f0;
	public float f1;

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeByte(m_type);
		if (m_type == 0) {
			out.writeLong(l0);
		} else if (m_type == 1) {
		} else if (m_type == 2) {
			out.writeFloat(f0);
		} else if (m_type == 3) {
			out.writeFloat(f0);
			out.writeFloat(f1);
		}
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		m_type = in.readByte();
		if (m_type == 0) {
			l0 = in.readLong();
		} else if (m_type == 1) {
		} else if (m_type == 2) {
			f0 = in.readFloat();
		} else if (m_type == 3) {
			f0 = in.readFloat();
			f1 = in.readFloat();
		}
	}
}

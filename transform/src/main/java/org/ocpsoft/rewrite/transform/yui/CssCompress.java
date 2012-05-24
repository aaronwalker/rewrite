/*
 * Copyright 2011 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ocpsoft.rewrite.transform.yui;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;

import org.ocpsoft.rewrite.transform.Transformer;

import com.yahoo.platform.yui.compressor.CssCompressor;

/**
 * 
 * CSS compressor implementation based on yuicompressor
 * 
 * @author Christian Kaltepoth
 * 
 */
public class CssCompress implements Transformer
{

   private final Charset charset;

   public CssCompress()
   {
      this(Charset.forName("UTF8"));
   }

   public CssCompress(Charset charset)
   {
      this.charset = charset;
   }

   @Override
   public void transform(InputStream input, OutputStream output) throws IOException
   {

      // prepare input reader
      Reader reader = new InputStreamReader(input, charset);
      CssCompressor compressor = new CssCompressor(reader);

      // write compressed output
      OutputStreamWriter writer = new OutputStreamWriter(output, charset);
      compressor.compress(writer, 0);
      writer.flush();

   }

}